package rocket

import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.*
import org.jetbrains.kotlinx.dataframe.io.read
import org.jetbrains.kotlinx.dataframe.columns.toColumnSet
import kotlinx.serialization.json.*
import kotlinx.serialization.*
import Config
import weka.core.converters.ConverterUtils.DataSource;

import java.io.File
import weka.classifiers.Evaluation
import weka.classifiers.bayes.NaiveBayes
import weka.classifiers.meta.Bagging
import weka.classifiers.trees.J48
import weka.classifiers.trees.RandomForest
import weka.core.converters.CSVLoader
import weka.filters.Filter
import weka.filters.unsupervised.attribute.NumericToNominal
import weka.classifiers.meta.FilteredClassifier

class DataProcessing {
    
    /*

    ------------- This is for both functions -------------

    TO-DO:
    1) Update config struct to add seed & iterationsAmount fields
    2) Set "classifier.numIterations" from config
    3) Set "classifier.seed" from config
    4) Update config struct to add training & testing datasets path
    
    */

    fun processC50() {

        val config = Json.decodeFromString<Config>(File("src/main/resources/config.json").readText())
    
        val trainLoader = CSVLoader()
        trainLoader.setSource(File("src/main/resources/train_datasets/1_train_45000.csv"))
        trainLoader.fieldSeparator = ";"
        val dataset = trainLoader.dataSet
        dataset.setClassIndex(dataset.numAttributes() - 1)
    
        val filter = NumericToNominal()
        filter.setAttributeIndices((dataset.classIndex() + 1).toString())
        filter.setInputFormat(dataset)
        val nominalDataset = Filter.useFilter(dataset, filter)
    
        val classifier = Bagging()
        classifier.classifier = J48()
        classifier.numIterations = 1
        classifier.seed = 1
    
        classifier.buildClassifier(nominalDataset)
    
        val testLoader = CSVLoader()
        testLoader.setSource(File("src/main/resources/test_datasets/1_test_15000.csv"))
        testLoader.fieldSeparator = ";"
        val testDataset = testLoader.dataSet
        testDataset.setClassIndex(testDataset.numAttributes() - 1)
    
        val testFilter = NumericToNominal()
        testFilter.setAttributeIndices((testDataset.classIndex() + 1).toString())
        testFilter.setInputFormat(testDataset)
        val nominalTestDataset = Filter.useFilter(testDataset, testFilter)
    
        val evaluation = Evaluation(nominalTestDataset)
        evaluation.evaluateModel(classifier, nominalTestDataset)
    
        println(evaluation.toSummaryString())
    }

    fun processRandomForest() {

        val config = Json.decodeFromString<Config>(File("src/main/resources/config.json").readText())
    
        val loader = CSVLoader()
        loader.setSource(File("src/main/resources/train_datasets/0_train_15000.csv"))
        loader.fieldSeparator = ";"
        val dataset = loader.dataSet
    
        dataset.setClassIndex(dataset.numAttributes() - 1)
    
        val filter = NumericToNominal()
        filter.setAttributeIndices((dataset.classIndex() + 1).toString())
        filter.setInputFormat(dataset)
        val nominalDataset = Filter.useFilter(dataset, filter)
     
        val classifier = RandomForest()
        classifier.numIterations = 1
        classifier.seed = 1
    
        classifier.buildClassifier(nominalDataset)
    
        val testLoader = CSVLoader()
        testLoader.setSource(File("src/main/resources/test_datasets/0_test_5000.csv"))
        testLoader.fieldSeparator = ";"
        val testDataset = testLoader.dataSet
    
        testDataset.setClassIndex(testDataset.numAttributes() - 1)
    
        val testFilter = NumericToNominal()
        testFilter.setAttributeIndices((testDataset.classIndex() + 1).toString())
        testFilter.setInputFormat(testDataset)
        val nominalTestDataset = Filter.useFilter(testDataset, testFilter)
    
        val evaluation = Evaluation(nominalTestDataset)
        evaluation.evaluateModel(classifier, nominalTestDataset)
    
        println(evaluation.toSummaryString())
    }
    
}
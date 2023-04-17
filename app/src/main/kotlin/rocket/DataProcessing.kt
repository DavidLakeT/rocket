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
    fun process() {

        val config = Json.decodeFromString<Config>(File("src/main/resources/config.json").readText())
    
        val loader = CSVLoader()
        loader.setSource(File("src/main/resources/train_datasets/1_train_45000.csv"))
        loader.fieldSeparator = ";"
        val dataset = loader.dataSet
    
        // Set the class index to the last attribute
        dataset.setClassIndex(dataset.numAttributes() - 1)
    
        // Convert the class attribute from numeric to nominal
        val filter = NumericToNominal()
        filter.setAttributeIndices((dataset.classIndex() + 1).toString())
        filter.setInputFormat(dataset)
        val nominalDataset = Filter.useFilter(dataset, filter)
    
        // Create a Bagging ensemble of J48 decision tree classifiers
        val classifier = Bagging()
        classifier.classifier = J48()
        classifier.numIterations = 1
        classifier.seed = 1
    
        // Train the classifier on the dataset
        classifier.buildClassifier(nominalDataset)
    
        // Load test data
        val testLoader = CSVLoader()
        testLoader.setSource(File("src/main/resources/test_datasets/1_test_15000.csv"))
        testLoader.fieldSeparator = ";"
        val testDataset = testLoader.dataSet
    
        // Set the class index to the last attribute
        testDataset.setClassIndex(testDataset.numAttributes() - 1)
    
        // Convert the class attribute from numeric to nominal
        val testFilter = NumericToNominal()
        testFilter.setAttributeIndices((testDataset.classIndex() + 1).toString())
        testFilter.setInputFormat(testDataset)
        val nominalTestDataset = Filter.useFilter(testDataset, testFilter)
    
        // Evaluate the classifier using test data
        val evaluation = Evaluation(nominalTestDataset)
        evaluation.evaluateModel(classifier, nominalTestDataset)
    
        // Print out the results
        println(evaluation.toSummaryString())
        println(evaluation.toClassDetailsString())
        println(evaluation.toMatrixString())
    }

    fun processRandomForest() {

        val config = Json.decodeFromString<Config>(File("src/main/resources/config.json").readText())
    
        val loader = CSVLoader()
        loader.setSource(File("src/main/resources/train_datasets/0_train_15000.csv"))
        loader.fieldSeparator = ";"
        val dataset = loader.dataSet
    
        // Set the class index to the last attribute
        dataset.setClassIndex(dataset.numAttributes() - 1)
    
        // Convert the class attribute from numeric to nominal
        val filter = NumericToNominal()
        filter.setAttributeIndices((dataset.classIndex() + 1).toString())
        filter.setInputFormat(dataset)
        val nominalDataset = Filter.useFilter(dataset, filter)
     
        // Create a random forest classifier
        val classifier = RandomForest()
        classifier.numIterations = 1
        classifier.seed = 1
    
        // Train the classifier on the dataset
        classifier.buildClassifier(nominalDataset)
    
        // Load test data
        val testLoader = CSVLoader()
        testLoader.setSource(File("src/main/resources/test_datasets/0_test_5000.csv"))
        testLoader.fieldSeparator = ";"
        val testDataset = testLoader.dataSet
    
        // Set the class index to the last attribute
        testDataset.setClassIndex(testDataset.numAttributes() - 1)
    
        // Convert the class attribute from numeric to nominal
        val testFilter = NumericToNominal()
        testFilter.setAttributeIndices((testDataset.classIndex() + 1).toString())
        testFilter.setInputFormat(testDataset)
        val nominalTestDataset = Filter.useFilter(testDataset, testFilter)
    
        // Evaluate the classifier using test data
        val evaluation = Evaluation(nominalTestDataset)
        evaluation.evaluateModel(classifier, nominalTestDataset)
    
        // Print out the results
        println(evaluation.toSummaryString())
        println(evaluation.toClassDetailsString())
        println(evaluation.toMatrixString())
    }
    
}
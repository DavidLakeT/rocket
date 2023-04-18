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
    5) Update config struct to add separator character (';')
    
    */

    fun processC45() {
        try {
            val config = Json.decodeFromString<Config>(File("src/main/resources/config.json").readText())
    
            val trainLoader = CSVLoader()
            //trainLoader.setSource(File("src/main/resources/train_datasets/0_train_15000.csv"))
            trainLoader.setSource(File(config.trainning_dataset))
            trainLoader.fieldSeparator = config.separator
            val trainDataset = trainLoader.dataSet
            trainDataset.setClassIndex(trainDataset.numAttributes() - 1)
    
            val trainFilter = NumericToNominal()
            trainFilter.setAttributeIndices((trainDataset.classIndex() + 1).toString())
            trainFilter.setInputFormat(trainDataset)
            val nominalTrainDataset = Filter.useFilter(trainDataset, trainFilter)
    
            val classifier = Bagging()
            classifier.classifier = J48()
            classifier.numIterations = config.num_iterations_C45
            classifier.seed = config.seed_C45
            classifier.buildClassifier(nominalTrainDataset)
    
            val testLoader = CSVLoader()
            testLoader.setSource(File(config.testing_dataset))
            testLoader.fieldSeparator = config.separator
            val testDataset = testLoader.dataSet
            testDataset.setClassIndex(testDataset.numAttributes() - 1)

            val testFilter = NumericToNominal()
            testFilter.setAttributeIndices((testDataset.classIndex() + 1).toString())
            testFilter.setInputFormat(testDataset)
            val nominalTestDataset = Filter.useFilter(testDataset, testFilter)
    
            val evaluation = Evaluation(nominalTestDataset)
            evaluation.evaluateModel(classifier, nominalTestDataset)
    
            println(evaluation.toSummaryString())
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    fun processRandomForest() {
        try {
            val config = Json.decodeFromString<Config>(File("src/main/resources/config.json").readText())
    
            val trainLoader = CSVLoader()
            trainLoader.setSource(File(config.trainning_dataset))
            trainLoader.fieldSeparator = config.separator
            val dataset = trainLoader.dataSet
            dataset.setClassIndex(dataset.numAttributes() - 1)
    
            val filter = NumericToNominal()
            filter.setAttributeIndices((dataset.classIndex() + 1).toString())
            filter.setInputFormat(dataset)
            val nominalDataset = Filter.useFilter(dataset, filter)
    
            val classifier = RandomForest()
            classifier.numIterations = config.num_iterations_RF
            classifier.seed = config.seed_RF
            classifier.buildClassifier(nominalDataset)
    
            val testLoader = CSVLoader()
            testLoader.setSource(File(config.testing_dataset))
            testLoader.fieldSeparator = config.separator
            val testDataset = testLoader.dataSet
            testDataset.setClassIndex(testDataset.numAttributes() - 1)

            val testFilter = NumericToNominal()
            testFilter.setAttributeIndices((testDataset.classIndex() + 1).toString())
            testFilter.setInputFormat(testDataset)
            val nominalTestDataset = Filter.useFilter(testDataset, testFilter)
    
            val evaluation = Evaluation(nominalTestDataset)
            evaluation.evaluateModel(classifier, nominalTestDataset)

            println(evaluation.toSummaryString())
        } catch (e: Exception) {

            println("Error: ${e.message}")
        }
    }
}

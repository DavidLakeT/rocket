
```
Colaborators:
- Juan David Valencia Torres, jdvalencit@eafit.edu.co
- Kevin Mauricio Loaiza Arango, kmloaizaa@eafit.edu.co
- David Cardona, djcardonan@eafit.edu.co
```

# Rocket

Rocket is a Data Science project that uses classification algorithms such as C4.5 and RandomForest to predict the academic success of students in higher education tests.
It works with different datasets composed of both numerical and nominal data.

##  Implementation

The use of Weka's J48 and RandomForest libraries for training and validating the models is a common practice in the field of data science. These libraries are known for their robustness and ability to handle large datasets. By utilizing these libraries, the project has ensured that the models are accurate and reliable.

The datasets used for training and validation were taken from the [Data Icfes Website](https://www2.icfes.gov.co/data-icfes), which is a valuable resource for data scientists working in the field of education. These datasets contain information about the performance of students in various academic areas, including math, science, and language. By using these datasets, the project has been able to develop models that can predict student performance based on various factors, such as demographic information, academic history, and socioeconomic status.
Moving forward, it is essential to continue exploring new data sources and file formats to ensure that data scientists have the tools they need to conduct effective data analysis.

## Usage

### Cloning  the repository
First, you need to clone the repository from GitHub. To do this, you can open a terminal and run the following command:
```
git clone https://github.com/jdvalencit/system-monitor.git
```

### Building the program

To compile the program, navigate to the `rocket` directory in the terminal and run by using the following commands:
```
cd rocket
./gradlew build
```

### Running the program

To run the program, navigate to the `rocket` directory in the terminal and run by using the following commands:
```
cd rocket
./gradlew run
```

## Conclusions
Data science implementations has become an essential tool for businesses to analyze their data, gain insights, and make data-driven decisions. The successful implementation of data science in any organization depends on various factors, including the availability of quality data, skilled data scientists, and robust tools to perform data analysis.
Overall, this Data Science implementation has achieved its main objectives. The use of the libraries provided by Weka made it possible to cover configuration aspects such as the specification of the separator character to be used, as well as the creation and validation of a model with multiple trees (looking for the best result).

There are some limitations that could be addressed in future implementations. Most of those related to adding support to other file formats (e.g. arff) and functionalities for dataset pre-processing.

## References
- [1] [geeksforgeeks: Gini impurity and entropy in decision tree ml](https://www.geeksforgeeks.org/gini-impurity-and-entropy-in-decision-tree-ml/)
- [2] [What is the C4.5 algorithm and how does it work? | by Sumit Saha | Towards Data Science](https://towardsdatascience.com/what-is-the-c4-5-algorithm-and-how-does-it-work-2b971a9e7db0)
- [3] [J48 (sourceforge.io)](https://weka.sourceforge.io/doc.dev/weka/classifiers/trees/J48.html)
- [4] [RandomForest (sourceforge.io)](https://weka.sourceforge.io/doc.dev/weka/classifiers/trees/RandomForest.html)
- [5] [Kotlin for data science | Kotlin Documentation (kotlinlang.org)](https://kotlinlang.org/docs/data-science-overview.html#kotlin-notebooks-in-datalore)

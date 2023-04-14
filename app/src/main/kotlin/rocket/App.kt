package rocket

import java.io.File
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.context.InsufficientFieldsRowBehaviour

class App {
    fun loadDataset() {
        val dataset = "lite.csv"
        val file = File(javaClass.classLoader.getResource(dataset).toURI())

        if (!file.exists()) {
            println("El archivo $dataset no existe.")
            return
        }

        val csvReader = csvReader {
            delimiter = ';'
            insufficientFieldsRowBehaviour = InsufficientFieldsRowBehaviour.EMPTY_STRING
        }

        val rows: List<Map<String, String>> = csvReader.readAllWithHeader(file)
    }
}


fun main() {
    val myApp = App()
    println(myApp.loadDataset())
}

package rocket

import java.io.File
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.context.InsufficientFieldsRowBehaviour
import com.github.doyaaaaaken.kotlincsv.client.CsvReader

class App {
    fun loadDataset(): List<Student> {
        val dataset = "lite.csv"
        val file = File(javaClass.classLoader.getResource(dataset).toURI())

        val csvReader = csvReader {
            delimiter = ';'
            insufficientFieldsRowBehaviour = InsufficientFieldsRowBehaviour.EMPTY_STRING
        }

        val res = csvReader.readAllWithHeader(file).map {
            Student(
                document = it["estu_tipodocumento.1"]!!.trim()
            )
        }.toList()

        return res
    }
}


fun main() {
    val myApp = App()
    println(myApp.loadDataset())
}

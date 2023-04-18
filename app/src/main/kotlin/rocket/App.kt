package rocket

import java.io.File
import java.util.Scanner
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.context.InsufficientFieldsRowBehaviour
import com.github.doyaaaaaken.kotlincsv.client.CsvReader
import kotlin.io.println

fun main() {
    val processer = DataProcessing()
    
    do{
        println("Choose one of the following options:")
        println("1. C45")
        println("2. Random Forest")
        println("3. Both")
        println("4. Exit")

        val input = readLine()

        when (input) {
            "1" -> processer.processC45()
            "2" -> processer.processRandomForest()
            "3" -> {
                processer.processC45()
                processer.processRandomForest()
            }
            "4" -> println("Exiting")
            else -> println("Not an option")
        }
    } while (input != "4")
}

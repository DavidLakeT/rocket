package rocket

import java.io.File
import java.util.Scanner
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.context.InsufficientFieldsRowBehaviour
import com.github.doyaaaaaken.kotlincsv.client.CsvReader

fun main() {
    val processer = DataProcessing()
    
    println("Choose one of the following options:")
    println("1. C45")
    println("2. Random Forest")
    println("3. Both")

    val input = readLine()
    print("Enter a number: ")

    when (input) {
        "1" -> processer.processC45()
        "2" -> processer.processRandomForest()
        "3" -> {
            processer.processC45()
            processer.processRandomForest()
        }
        else -> println("Not an option")
    }
}

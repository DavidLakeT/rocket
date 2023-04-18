package rocket

import java.io.File
import java.util.Scanner
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.context.InsufficientFieldsRowBehaviour
import com.github.doyaaaaaken.kotlincsv.client.CsvReader

fun main() {
    val processer = DataProcessing()
    
    processer.processC45()
}

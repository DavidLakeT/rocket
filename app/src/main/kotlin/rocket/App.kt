package rocket

import java.io.File
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.context.InsufficientFieldsRowBehaviour
import com.github.doyaaaaaken.kotlincsv.client.CsvReader

fun main() {
    val daf = DataProcessing()
    
    //daf.processC50()
    daf.processRandomForest()
}
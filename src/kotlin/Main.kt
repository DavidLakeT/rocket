package team.homelake.rocket

import java.io.File
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

fun main() {
    val file: File = File("datasets/lite.csv")
    val rows: List<Map<String, String>> = csvReader().readAllWithHeader(file)
    println(rows) //[{a=d, b=e, c=f}]
}

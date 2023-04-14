package rocket

import java.io.File
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.InputStreamReader

class App {
    val greeting: String
    
    get() {
        return "Hello World!"
    }
}

fun main() {
    println(App().greeting)
}

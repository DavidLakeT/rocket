package rocket

import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.*
import org.jetbrains.kotlinx.dataframe.io.read
import java.io.File

class DataProcessing {

    fun readDataframe() {

        val ids by column<String>()

        val df = DataFrame.read(
            File(javaClass.classLoader.getResource("lite.csv").toURI())
        )
    }
}
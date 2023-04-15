package rocket

import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.*
import org.jetbrains.kotlinx.dataframe.io.read
import java.io.File

class DataProcessing {
    fun readDataframe() {

        val df = DataFrame.read(
            "src/main/resources/grandecito.csv",
            delimiter = ';',
        )

        println(df["estu_genero.1", "exito"])
    }
}
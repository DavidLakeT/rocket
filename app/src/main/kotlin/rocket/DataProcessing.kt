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

        /*
        
        TO-DO #1:
        - define columnList with names of columns to be processed (listOf)
        - df = df[columnList]

        TO-DO #2:
        - Gini calculation
        - map results (could be another DataFrame)

         */

        println(df["estu_genero.1", "exito"])
    }
}
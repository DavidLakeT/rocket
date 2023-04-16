package rocket

import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.*
import org.jetbrains.kotlinx.dataframe.io.read
import java.io.File
import org.jetbrains.kotlinx.dataframe.columns.toColumnSet
import kotlinx.serialization.json.*
import kotlinx.serialization.*
import Config

class DataProcessing {
    fun readDataframe() {

        val df = DataFrame.read(
            "src/main/resources/lite.csv",
            delimiter = ';',
        ).select { config.columnList.toColumnSet() }

        /*
        
        TO-DO #1:
        - define columnList with names of columns to be processed (listOf)
        - df = df[columnList]

        TO-DO #2:
        - Gini calculation
        - map results (could be another DataFrame)

        */

        print(df)

        //correlation matrix
        print(df.corr())

    }
}
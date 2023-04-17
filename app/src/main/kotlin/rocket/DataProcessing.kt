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

        val config = Json.decodeFromString<Config>(File("src/main/resources/config.json").readText())

        val df = DataFrame.read(
            "src/main/resources/lite.csv",
            delimiter = ';',
        ).select { config.columnList.toColumnSet() }

        /*

        TO-DO #1 (Assignee: jdvalencit):
        - Implement function for calculating Gini coefficient on Categoric columns.
        - Export results to Jupyter or CSV.

        TO-DO #2 (Assignee: DavidLakeT):
        - Implement function for calculating Pearson coefficient on Categoric columns (corr()).
        - Export results to Jupyter or CSV.
        - Check how this compares to Gini and if there's a direct conversion.

        */

        //correlation matrix
        print(df.corr())

    }
}
package rocket

import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.*
import org.jetbrains.kotlinx.dataframe.io.read
import java.io.File
import org.jetbrains.kotlinx.dataframe.columns.toColumnSet

class DataProcessing {
    fun readDataframe() {

        val df = DataFrame.read(
            "src/main/resources/lite.csv",
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

        val columnList = listOf("estu_consecutivo.1", "estu_cod_reside_mcpio.1", "cole_codigo_icfes", "cole_cod_dane_establecimiento", "cole_cod_dane_sede", "cole_cod_mcpio_ubicacion", "cole_cod_depto_ubicacion").toColumnSet()

        df = df.select { columnList }

        print(df)
    }
}
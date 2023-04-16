package rocket

import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.*
import org.jetbrains.kotlinx.dataframe.io.read
import java.io.File
import org.jetbrains.kotlinx.dataframe.columns.toColumnSet

class DataProcessing {
    fun readDataframe() {

        var df = DataFrame.read(
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

        // "fami_numlibros", "estu_depto_reside.1", "estu_genero.1",

        /*
        // eliminar las columnas que no son numéricas o que tienen valores faltantes
        val numericCols = df.numericColumns().names().filterNot { col -> df.column(col).isMissing.any() }

        // calcular el coeficiente de correlación entre cada columna numérica y la columna "exito"
        val correlations = mutableMapOf<String, Double>()
        for (col in numericCols) {
            val x = df.column(col).toDoubleArray()
            val y = df.column("exito").toDoubleArray()
            val model = OLS.fit(x, y)
            correlations[col] = model.correlation
        }

        // mostrar las correlaciones ordenadas de mayor a menor
        correlations.toList().sortedByDescending { (_, value) -> abs(value) }.forEach { (col, corr) ->
            println("$col: $corr")
        }

        */

        val columns = listOf("punt_filosofia", "punt_biologia", "exito").toColumnSet()

        val test = df.select { columns }

        print(test)
    }
}
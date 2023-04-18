import kotlinx.serialization.*

@Serializable
data class Config(
    val trainning_dataset: String,
    val testing_dataset: String,
    val num_iterations_C45: Int,
    val num_iterations_RF: Int,
    val seed_C45: Int,
    val seed_RF: Int,
    val separator: String
)

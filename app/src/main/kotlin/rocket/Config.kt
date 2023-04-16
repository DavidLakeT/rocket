import kotlinx.serialization.*

@Serializable
data class Config(
    val columnList: List<String>
)

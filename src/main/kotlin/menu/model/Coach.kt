package menu.model

data class Coach(
    val name: String,
    val diet: List<String> = mutableListOf(),
    val dislikeFood: List<String>? = mutableListOf(),
){}

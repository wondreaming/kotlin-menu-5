package menu.model

data class Coach(
    val name: String,
    val dislikeMenu: List<String>,
    val diet: List<String> = mutableListOf(),
){}

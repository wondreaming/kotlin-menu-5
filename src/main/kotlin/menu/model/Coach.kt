package menu.model

import camp.nextstep.edu.missionutils.Randoms

data class Coach(
    val name: String,
    val dislikeMenu: List<String>,
    val diet: MutableList<String> = mutableListOf(),
) {
    fun getDiet(category: Menu) {
        val menuItems = Randoms.shuffle(category.menuItems)
        for (menu in menuItems) {
            if (menu !in dislikeMenu && menu !in diet) {
                diet.add(menu)
                break
            }
        }
    }
}

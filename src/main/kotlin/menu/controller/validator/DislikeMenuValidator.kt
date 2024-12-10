package menu.controller.validator

import menu.model.Menu

class DislikeMenuValidator {
    operator fun invoke(input: String) {
        checkEmpty(input)
        val dislikeMenu = input.split(",")
        for (menu in dislikeMenu) {
            checkEmpty(menu)
            checkInMenu(menu)
        }
        checkSize(dislikeMenu)
    }

    private fun checkEmpty(input: String) {
        require(input.isNotEmpty()) { DislikeMenuErrorType.EMPTY_INPUT }
    }

    private fun checkInMenu(input: String) {
        require(Menu.values().any { it.getFindMenu(input) }) { DislikeMenuErrorType.NO_MENU }
    }

    private fun checkSize(input: List<String>) {
        require(input.size in 0..2) { DislikeMenuErrorType.SIZE }
    }
}
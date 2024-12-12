package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.controller.domain.UserInteractionController
import menu.controller.validator.CoachNamesValidator
import menu.controller.validator.DislikeMenuValidator
import menu.model.Coach
import menu.model.Menu
import menu.util.splitByComma

class MenuController(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
    private val coachNamesValidator: CoachNamesValidator = CoachNamesValidator(),
    private val dislikeMenuValidator: DislikeMenuValidator = DislikeMenuValidator(),
) {
    fun run() {
        val coachNames = getCoachNames()
        val coaches = getCoachDislikeMenu(coachNames)
        val categories = getCategories()
        getDiet(categories, coaches)
        userInteractionController.handleResult(coaches, categories)
    }

    private fun getCoachNames(): List<String> {
        userInteractionController.handleStartMsg()
        val coachNames = userInteractionController.handleCoachNames()
        coachNamesValidator(coachNames)
        val coaches = coachNames.splitByComma()
        return coaches
    }

    private fun getCoachDislikeMenu(coachNames: List<String>): List<Coach> {
        val coaches = mutableListOf<Coach>()
        for (coach in coachNames) {
            val coachDislikeMenu = userInteractionController.handleDislikeMenu(coach)
            dislikeMenuValidator(coachDislikeMenu)
            coaches.add(Coach(name = coach, dislikeMenu = coachDislikeMenu.splitByComma()))
        }
        return coaches
    }

    private fun getCategories(): List<Menu> {
        val categories = mutableListOf<Menu>()
        repeat(5) {
            val randomNumber = Randoms.pickNumberInRange(1, 5)
            val category = Menu.values().find { randomNumber == it.index }
            categories.add(category!!)
        }
        return categories
    }

    private fun getDiet(categories: List<Menu>, coaches: List<Coach>) {
        for (category in categories) {
            for (coach in coaches) {
                coach.getDiet(category)
            }
        }
    }
}
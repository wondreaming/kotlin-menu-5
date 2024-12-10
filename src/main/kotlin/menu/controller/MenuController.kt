package menu.controller

import menu.controller.domain.UserInteractionController
import menu.controller.validator.CoachNamesValidator
import menu.controller.validator.DislikeMenuValidator
import menu.model.Coach
import menu.util.splitByComma

class MenuController(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
    private val coachNamesValidator: CoachNamesValidator = CoachNamesValidator(),
    private val dislikeMenuValidator: DislikeMenuValidator = DislikeMenuValidator(),
) {
    fun run() {
        val coachNames = getCoachNames()
        val coaches = getCoachDislikeMenu(coachNames)
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
}
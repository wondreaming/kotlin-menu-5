package menu.controller

import menu.controller.domain.UserInteractionController
import menu.controller.validator.CoachNamesValidator
import menu.model.Coach
import menu.util.splitByComma

class MenuController(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
    private val coachNamesValidator: CoachNamesValidator = CoachNamesValidator(),
) {
    fun run() {
        val coaches = getCoachNames()
    }

    private fun getCoachNames(): List<Coach> {
        userInteractionController.handleStartMsg()
        val coachNames = userInteractionController.handleCoachNames()
        coachNamesValidator(coachNames)
        val coaches = coachNames.splitByComma().map { Coach(it) }
        return coaches
    }
}
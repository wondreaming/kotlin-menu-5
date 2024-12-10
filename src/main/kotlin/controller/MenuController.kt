package controller

import controller.domain.UserInteractionController

class MenuController(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
) {
    fun run() {
      getCoachNames()
    }

    private fun getCoachNames(){
        userInteractionController.handleStartMsg()
        userInteractionController.handleCoachNames()
    }
}
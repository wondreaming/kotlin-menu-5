package menu.controller.domain

import menu.model.Coach
import menu.view.InputView
import menu.view.OutputView

class UserInteractionController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    fun handleStartMsg() {
        outputView.showMsg("점심 메뉴 추천을 시작합니다.")
    }

    fun handleCoachNames(): String {
        outputView.showMsg("\n코치의 이름을 입력해 주세요. (, 로 구분)")
        val coachNames = inputView.getInput()
        return coachNames
    }

    fun handleDislikeMenu(coach: Coach): String {
        outputView.showMsg("${coach.name}가 못 먹는 메뉴를 입력해 주세요.")
        val dislikeMenu = inputView.getInput()
        return dislikeMenu
    }
}
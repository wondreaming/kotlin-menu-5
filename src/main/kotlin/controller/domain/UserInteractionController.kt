package controller.domain

import view.InputView
import view.OutputView

class UserInteractionController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    fun handleStartMsg() {
        outputView.showMsg("점심 메뉴 추천을 시작합니다.")
    }

    fun handleCoachNames(): String {
        outputView.showMsg("코치의 이름을 입력해 주세요. (, 로 구분)")
        val coachNames = inputView.getInput()
        return coachNames
    }
}
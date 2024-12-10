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
}
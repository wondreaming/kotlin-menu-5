package menu.controller.domain

import menu.model.Coach
import menu.model.Menu
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

    fun handleDislikeMenu(coach: String): String {
        outputView.showMsg("${coach}(이)가 못 먹는 메뉴를 입력해 주세요.")
        val dislikeMenu = inputView.getInput()
        return dislikeMenu
    }

    fun handleResult(coaches: List<Coach>, categories: List<Menu>) {
        outputView.showMsg("메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        outputView.showMsg("[ 카테고리 | ${categories.map { it.menuType }.joinToString(" | ")} ]")
        for (coach in coaches) {
            outputView.showMsg("[ ${coach.name} | ${coach.diet.joinToString(" | ")} ]")
        }
        outputView.showMsg("추천을 완료했습니다.")
    }
}
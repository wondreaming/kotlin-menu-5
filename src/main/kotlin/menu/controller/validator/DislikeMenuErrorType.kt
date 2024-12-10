package menu.controller.validator

enum class DislikeMenuErrorType(
    private val errorMessage: String
) {
    EMPTY_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    NO_MENU("음식이 메뉴판에 없습니다."),
    SIZE("싫어하는 음식은 0~2개만 입력할 수 있습니다.");

    override fun toString(): String = "$ERROR $errorMessage"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}
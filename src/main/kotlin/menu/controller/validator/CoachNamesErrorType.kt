package menu.controller.validator

enum class CoachNamesErrorType (
    private val errorMessage: String
) {
    EMPTY_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    LENGTH("코치 이름은 2에서 4사이 글자 수를 가집니다."),
    SIZE("코치는 2명에서 5명 사이만 같이 먹을 수 있습니다.");

    override fun toString(): String = "$ERROR $errorMessage"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}
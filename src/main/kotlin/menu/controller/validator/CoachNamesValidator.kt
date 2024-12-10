package menu.controller.validator

class CoachNamesValidator {
    operator fun invoke(input: String) {
        checkEmpty(input)
        val coachNames = input.split(",")
        for (coachName in coachNames) {
            checkEmpty(coachName)
            checkLength(coachName)
        }
        checkSize(coachNames)
    }

    private fun checkEmpty(input: String) {
        require(input.isNotEmpty()) { CoachNamesErrorType.EMPTY_INPUT }
    }

    private fun checkLength(input: String) {
        require(input.length in 2..4) { CoachNamesErrorType.LENGTH }
    }

    private fun checkSize(input: List<String>) {
        require(input.size in 2..5) { CoachNamesErrorType.SIZE }
    }
}
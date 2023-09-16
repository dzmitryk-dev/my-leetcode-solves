package interview.strings

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/884/
 */

fun myAtoi(s: String): Int {
    var result = 0
    var sign = 1
    var currentState = State.START
    for (symbol in s) {
        val newState = state(currentState, symbol)
        when(newState) {
            State.STOP -> return result * sign
            State.NUMBER -> try {
                result = Math.addExact(Math.multiplyExact(result, 10), Character.getNumericValue(symbol))
            } catch (ex: ArithmeticException) {
                return if (sign > 0) {
                    Int.MAX_VALUE
                } else {
                    Int.MIN_VALUE
                }
            }
            State.SIGN -> if (symbol == '-') {
                sign = -1
            }
           else -> { }
        }
        currentState = newState
    }
    return result * sign
}

private enum class State {
    START, IGNORING, STOP, NUMBER, SIGN
}

private fun state(currentState: State, symbol: Char): State {
    return when(currentState) {
        State.START,
        State.IGNORING -> {
            when {
                symbol.isWhitespace() -> State.IGNORING
                symbol.isDigit() -> State.NUMBER
                symbol == '-' ||
                symbol == '+' -> State.SIGN
                else -> State.STOP
            }
        }
        State.NUMBER -> {
            when {
                symbol.isWhitespace() -> State.STOP
                symbol.isDigit() -> State.NUMBER
                symbol == '-' ||
                symbol == '+' -> State.STOP
                else -> State.STOP
            }
        }
        State.SIGN -> {
            when {
                symbol.isDigit() -> State.NUMBER
                else -> State.STOP
            }
        }
        State.STOP -> throw IllegalStateException("Stop state is the last possible state")
    }
}
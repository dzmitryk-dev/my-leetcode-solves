package challenges.february2021

/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3653/
 */
fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
    if (pushed.isEmpty()) return true

    val stack = mutableListOf<Int>()
    val pushedIterator = pushed.iterator()

    for (poppedValue in popped) {
        var pushedValue = stack.lastOrNull()
        when {
            pushedValue == poppedValue -> {
                stack.removeAt(stack.lastIndex)
            }
            pushedIterator.hasNext() -> {
                while (pushedIterator.hasNext()) {
                    pushedValue = pushedIterator.nextInt()
                    if (pushedValue != poppedValue) {
                        stack.add(pushedValue)
                    } else {
                        break
                    }
                }
            }
            else -> {
                return false
            }
        }
    }
    return true
}
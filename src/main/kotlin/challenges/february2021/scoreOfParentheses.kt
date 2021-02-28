package challenges.february2021

/*
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3651/
 */

fun scoreOfParentheses(S: String): Int {
    val stack = mutableListOf<Int>()
    for (c in S) {
        if (c == '(') {
            stack.add(0)
        } else {
            if (stack.last() == 0) {
                stack.removeAt(stack.lastIndex)
                stack.add(1)
            } else {
                var sum = 0
                while (stack.last() != 0) {
                    sum += stack.last()
                    stack.removeAt(stack.lastIndex)
                }
                sum *= 2
                stack.removeAt(stack.lastIndex)
                stack.add(sum)
            }
        }
    }
    return stack.reduce { acc, i -> acc + i }
}
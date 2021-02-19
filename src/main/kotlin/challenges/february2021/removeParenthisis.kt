package challenges.february2021

import java.lang.StringBuilder
import java.util.*

/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3645/
 */

fun minRemoveToMakeValid(s: String): String {
    val stack : Stack<Int> = Stack()
    val content = s.toCharArray()
    for ((index, char) in content.withIndex()) {
        if (char == '(') {
            stack.push(index)
        } else if (char == ')') {
            if (stack.empty()) {
                content[index] = 0.toChar()
            } else {
                stack.pop()
            }
        }
    }
    while (!stack.empty()) {
        content[stack.pop()] = 0.toChar()
    }
    return content.fold(StringBuilder()) { acc, c ->
        acc.apply {
            if (c != 0.toChar()) {
                append(c)
            }
        }
    }.toString()
}
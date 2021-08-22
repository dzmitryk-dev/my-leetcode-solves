package general

import java.util.*

// https://leetcode.com/problems/valid-parentheses/

private val closeParenthesis = arrayOf('}', ']', ')')

private val parenthesisMap = mapOf<Char, Char>(
    '}' to '{', ']' to '[', ')' to '('
)

fun isValidParentheses(s: String): Boolean {
    val stack = LinkedList<Char>()
    for (symbol in s) {
        if(stack.isEmpty() ||
            symbol !in closeParenthesis ||
            stack.peek() != parenthesisMap[symbol]
        ) {
            stack.push(symbol)
        } else {
            stack.pop()
        }
    }
    return stack.isEmpty()
}
package general

/**
 * https://leetcode.com/problems/keyboard-row/
 */

//private val rows = setOf(
//    setOf('q', 'w', 'e', 'r', 't','y', 'u', 'i', 'o', 'p'),
//    setOf('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'),
//    setOf('z', 'x', 'c', 'v', 'b', 'n', 'm')
//)

private val map = listOf(
    "qwertyuiop", "asdfghjkl", "zxcvbnm"
).flatMapIndexed { index, chars ->
    chars.map { c -> c to index }
}.toMap()

fun findWords(words: Array<String>): Array<String> {
    return words.filter { w ->
        val i = map[w[0].lowercaseChar()]!!
        w.all { c -> map[c.lowercaseChar()] == i }
    }.toTypedArray()
}
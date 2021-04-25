package general

/**
    https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */

fun countCharacters(words: Array<String>, chars: String): Int {
    val charsPrepared = chars.countChars()
    return words.map { it.countChars() to it.length }
        .filter { (word, lenght) -> canBeFormed(charsPrepared, word) }
        .fold(0) { acc, (_, lenght) -> acc + lenght }
}

private fun String.countChars(): Map<Char, Int> =
    this.groupBy { it }
        .mapValues { (_, values) -> values.size }

private fun canBeFormed(base: Map<Char, Int>, word: Map<Char, Int>): Boolean {
    return base.size >= word.size && base.keys.containsAll(word.keys) && word.all { (s, count) -> count <= base.getOrDefault(s, 0) }
}
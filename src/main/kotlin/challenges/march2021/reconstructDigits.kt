package challenges.march2021

/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3687/
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/submissions/
 */

fun originalDigits(s: String): String {
    var map = s.prepareString()
    val output = mutableListOf<Int>()

    uniqWords.forEach { (preparedWord, value) ->
        val size = map.countWord(preparedWord)
        if (size > 0) {
            repeat(size) {
                map = map.removeWord(preparedWord)
                output.add(value)
            }
        }
    }
    output.addAll(findNumbers(map))
    output.sort()

    return output.joinToString(separator = "") { it.toString() }
}

private fun findNumbers(string: Map<Char, Int>, acc: List<Int> = emptyList()): List<Int> {
    return if (string.isEmpty()) {
        acc.sorted()
    } else {
        val (preparedWord, value ) = wordlist.first {(preparedWord, _) -> string.containWord(preparedWord) }
        return findNumbers(string.removeWord(preparedWord), acc + value)
    }
}

private fun String.prepareString(): Map<Char, Int> =
    this.asIterable().fold(mutableMapOf()) { acc, c ->
        acc.also {
            it[c] = it.getOrDefault(c, 0) + 1
        }
    }

private fun Map<Char, Int>.countWord(preparedWord: Map<Char, Int>): Int {
   return  preparedWord.entries.map { (key,count) ->
        key to this.getOrDefault(key, 0) / count
    }.let {
        val wordCount = it.minBy { (_, count) -> count }?.second ?: 0
        val isContain = it.all { (_, count) -> count >= wordCount }
        if (isContain) {
            wordCount
        } else {
            0
        }
    }
}

private fun Map<Char, Int>.containWord(preparedWord: Map<Char, Int>): Boolean {
    return  preparedWord.entries.map { (key,count) ->
        key to this.getOrDefault(key, 0) / count
    }.let {
        val wordCount = it.minBy { (_, count) -> count }?.second ?: 0
        it.all { (_, count) -> count > 0 && count >= wordCount }
    }
}

private fun Map<Char, Int>.removeWord(preparedWord: Map<Char, Int>): Map<Char, Int> {
    val mutable = this.toMutableMap()
    preparedWord.entries.forEach { (key, count) ->
        val newValue = mutable[key]!! - count
        if (newValue > 0) {
            mutable[key] = newValue
        } else {
            mutable.remove(key)
        }
    }
    return mutable
}

private val uniqWords = listOf("zero" to 0, "two" to 2, "four" to 4, "six" to 6)
    .map { (word, value) ->
        word.prepareString() to value
    }
private val wordlist = listOf("one" to 1, "three" to 3, "five" to 5, "seven" to 7, "eight" to 8, "nine" to 9)
    .map { (word, value) ->
        word.prepareString() to value
    }

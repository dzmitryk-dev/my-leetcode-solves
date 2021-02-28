package challenges.february2021

/*
    https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3655/
 */

class FreqStack {

    private val stack = mutableListOf<Int>()
    private val map = mutableMapOf<Int, Int>()

    fun push(x: Int) {
        map.compute(x) { _, oldValue ->
            stack.add(x)
            oldValue?.let { it + 1 } ?: 1
        }
    }

    fun pop(): Int {
        val index =  map.entries
            .sortedByDescending { (_, value) -> value }
            .takeIf { it[0].value > 1 }
            ?.let {
                val maxCount = it[0].value
                it.takeWhile { (_, value) -> value == maxCount }
            }?.map { (key, _) -> key }
            ?.let { mostFreqValue ->
                stack.indexOfLast { it in mostFreqValue }
            } ?: stack.lastIndex
        val removedValue = stack.removeAt(index)
        map.compute(removedValue) { _, oldValue ->
            oldValue?.let { it - 1 }
        }
        return removedValue
    }
}
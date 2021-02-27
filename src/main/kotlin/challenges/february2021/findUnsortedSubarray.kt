package challenges.february2021

/*
    https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3652/
 */

fun findUnsortedSubarray(nums: IntArray): Int {
    var startIndex = 0
    var endIndex = 0
    val sortedNums = nums.sortedArray()
    for ((index, value) in nums.withIndex()) {
        if (value != sortedNums[index]) {
            startIndex = index
            break
        }
    }
    for ((i, value) in nums.reversed().withIndex()) {
        val index = nums.lastIndex - i
        if (value != sortedNums[index]) {
            endIndex = index
            break
        }
    }
    return (endIndex - startIndex).let {
        if (it > 0) {
            it + 1
        } else {
            it
        }
    }
}
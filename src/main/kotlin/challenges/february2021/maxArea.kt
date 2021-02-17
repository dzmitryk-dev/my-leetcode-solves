package challenges.february2021

/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3643/
 */

fun maxArea(height: IntArray): Int {
    var firstIndex = 0
    var secondIndex = height.lastIndex
    var maxArea = area(height, firstIndex, secondIndex)
    while (firstIndex < secondIndex) {
        if (height[firstIndex] < height[secondIndex]) {
            firstIndex++
        } else {
            secondIndex--
        }
        val area = area(height, firstIndex, secondIndex)
        maxArea = maxOf(area, maxArea)
    }
    return maxArea
}

private fun area(height: IntArray, firstIndex: Int, secondIndex: Int): Int =
    minOf(height[firstIndex], height[secondIndex]) * (secondIndex - firstIndex)
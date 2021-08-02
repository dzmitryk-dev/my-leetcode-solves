package challenges.august2021

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3836/
 */

fun twoSum(nums: IntArray, target: Int): IntArray {
    if (nums.size == 2) return intArrayOf(0, 1)

    val valuesMap = nums.foldIndexed(mutableMapOf<Int, List<Int>>()) { index, map, v ->
        map[v] = map.getOrDefault(v, emptyList()) + index
        map
    }

    for ((value, indexes) in valuesMap) {
        val y = target - value
        if (y == value) {
            if (indexes.size > 1) {
                return intArrayOf(indexes[0], indexes[1])
            }
        } else {
            val yIndexes = valuesMap[y]
            if (yIndexes != null) {
                return intArrayOf(indexes.first(), yIndexes.first())
            }
        }
    }

    throw IllegalStateException()
}
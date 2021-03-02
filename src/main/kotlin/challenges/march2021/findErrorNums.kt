package challenges.march2021

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3658/
 */

fun findErrorNums(nums: IntArray): IntArray {
    val etalon = (1..nums.size).toSortedSet()
    val result = IntArray(2)
    for (value in nums) {
        if (!etalon.remove(value)) {
            result[0] = value
        }
    }
    result[1] = etalon.first()
    return result
}
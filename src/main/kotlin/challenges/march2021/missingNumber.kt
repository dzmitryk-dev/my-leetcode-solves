package challenges.march2021

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3659/
 */

fun missingNumber(nums: IntArray): Int {
    var sumExpected = 0
    var sumActual = 0
    for ((index, i) in nums.withIndex()) {
        sumExpected+=(index+1)
        sumActual+=i
    }
    return sumExpected - sumActual
}
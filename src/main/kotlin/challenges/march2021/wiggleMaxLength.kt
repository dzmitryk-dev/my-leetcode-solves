package challenges.march2021

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3676/
 */

fun wiggleMaxLength(nums: IntArray): Int {
    var counter = 1
    var startIndex = 1
    while (startIndex < nums.size && nums[startIndex] == nums[startIndex-1]) startIndex++
    if (startIndex == nums.size) return 1
    var increasing = nums[startIndex] < nums[startIndex - 1]
    for(i in startIndex..nums.lastIndex) {
        if (!increasing && nums[i] > nums[i-1] ||
            increasing && nums[i] < nums[i-1]
        ) {
            increasing = !increasing
            counter++
        }
    }
    return counter
}
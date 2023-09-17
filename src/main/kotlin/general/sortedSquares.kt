package general

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
fun sortedSquares(nums: IntArray): IntArray {
//    return nums.map { it * it }.sorted().toIntArray()
    val result = IntArray(nums.size)
    var left = 0
    var right = nums.lastIndex
    var resultIndex = nums.lastIndex

    while (left <= right) {
        val l = nums[left] * nums[left]
        val r = nums[right] * nums[right]
        result[resultIndex--] = if (l > r) {
            l.also { left++ }
        } else {
            r.also { right-- }
        }
    }

    return result
}

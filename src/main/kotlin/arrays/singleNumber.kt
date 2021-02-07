package arrays

fun singleNumber(nums: IntArray): Int {
    val size = nums.size
    if (size == 1) return nums[0]
    nums.sort()
    for (index in 0..size-3 step 2) {
        if (nums[index] != nums[index + 1]) {
            return nums[index]
        }
    }
    return nums[size - 1]
}
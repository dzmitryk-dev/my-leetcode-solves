package interview.arrays

fun moveZeroes(nums: IntArray) {
    val size = nums.size
    var indexToRead = 0
    for (index in 0..nums.lastIndex) {
        while (indexToRead < size && nums[indexToRead] == 0) {
            indexToRead++
        }
        if (index == indexToRead) {
            indexToRead++
            continue
        }
        if (indexToRead == size) {
            nums[index] = 0
            continue
        }
        nums[index] = nums[indexToRead]
        indexToRead++
    }
}
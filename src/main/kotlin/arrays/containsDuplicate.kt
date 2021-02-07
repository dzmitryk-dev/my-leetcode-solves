package arrays

fun containsDuplicate(nums: IntArray): Boolean {
    val set = hashSetOf<Int>()
    for (n in nums) {
        if (n in set) {
            return true
        }
        set.add(n)
    }
    return false
}
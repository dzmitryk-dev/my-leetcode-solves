package interview.arrays

fun rotate(nums: IntArray, k: Int) {
    val size = nums.size
    val realK = k % size
    if (size == 1 || realK == 0) {
        return
    }
    nums.reverse()
    nums.reverse(0, realK)
    nums.reverse(realK, size)
}

fun IntArray.reverse(fromIndex: Int, toIndex: Int): Unit {
    if (fromIndex < 0 || toIndex > size) {
        throw IndexOutOfBoundsException("fromIndex: $fromIndex, toIndex: $toIndex, size: $size")
    }
    if (fromIndex > toIndex) {
        throw IllegalArgumentException("fromIndex: $fromIndex > toIndex: $toIndex")
    }
    val midPoint = (fromIndex + toIndex) / 2
    if (fromIndex == midPoint) return
    var reverseIndex = toIndex - 1
    for (index in fromIndex until midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}
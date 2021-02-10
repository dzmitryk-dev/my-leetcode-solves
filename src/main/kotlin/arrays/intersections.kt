package arrays

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    nums1.sort()
    nums2.sort()

    val result = mutableListOf<Int>()

    var index1 = 0
    var index2 = 0
    while (index1 < nums1.size && index2 < nums2.size) {
        val i1 = nums1[index1]
        val i2 = nums2[index2]
        when {
            i1 == i2 -> {
                result.add(i1)
                index1++
                index2++
            }
            i1 > i2 -> {
                index2++
            }
            else -> {
                index1++
            }
        }
    }
    return result.toIntArray()
}
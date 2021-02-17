package interview.arrays

fun twoSum(nums: IntArray, target: Int): IntArray {
    if (nums.size == 2) return intArrayOf(0, 1)
    val map = mutableMapOf<Int, MutableSet<Int>>()
    val result = intArrayOf(0 ,0)
    nums.forEachIndexed { index, i ->
        val list = map.getOrPut(i) { mutableSetOf() }
        list.add(index)
    }
    map.forEach { (value, index1) ->
        val second = target - value
        if (second == value && index1.size > 1) {
            result[0] = index1.first()
            result[1] = index1.last()
            return@forEach
        } else {
            val index2 = map[second]
            if (index2 != null) {
                result[0] = index1.first()
                result[1] = index2.last()
                return@forEach
            }
        }
    }
    return result
}
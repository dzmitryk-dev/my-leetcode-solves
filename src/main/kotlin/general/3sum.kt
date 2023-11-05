package general

/**
 * https://leetcode.com/problems/3sum/description/
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    val sortedNums = nums.sorted()
    val result = mutableSetOf<List<Int>>()
    val handledPairs = mutableSetOf<Pair<Int, Int>>()

    var index1 = 0

    while (index1 < sortedNums.size) {
        val a = sortedNums[index1]
        var index2 = index1 + 1
        while (index2 < sortedNums.size) {
            val b = sortedNums[index2]
            if (a to b in handledPairs) {
                index2++
                continue
            }
            val c = 0 - b - a
            var index3 = index2 + 1
            while (index3 < sortedNums.size) {
                val z = sortedNums[index3]
                if (z == c) {
                    result.add(listOf(a, b, c))
                    handledPairs.add(a to b)
                    break
                }
                if (z > c) {
                    break
                }
                index3++
            }
            index2++
        }
        index1++
    }

    return result.toList()
}

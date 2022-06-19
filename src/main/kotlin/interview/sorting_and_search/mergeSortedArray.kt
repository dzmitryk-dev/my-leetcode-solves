package interview.sorting_and_search

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/
 */
fun merge(left: IntArray, m: Int, right: IntArray, n: Int): Unit {
    if (n == 0) {
        return
    }
    var insertIndex = n + m - 1
    var leftIndex = m - 1
    var rightIndex = n - 1
    while (rightIndex >= 0) {
        val r = right[rightIndex]
        if (leftIndex >= 0) {
            val l = left[leftIndex]
            if (l > r) {
                left[insertIndex] = l
                leftIndex--
                insertIndex--
                continue
            }
        }
        left[insertIndex] = r
        rightIndex--
        insertIndex--
    }
}
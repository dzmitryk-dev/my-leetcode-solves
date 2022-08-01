package general

import java.util.LinkedList
import java.util.Queue

/**
 * https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 */

fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
    var counter = 0
    var windowsStart = 0
    var windowEnd = k
    var currentSum = 0
    repeat(k) { index ->
        currentSum += arr[index]
    }
    if (currentSum.toDouble()/k >= threshold) {
        counter++
    }
    while (windowEnd < arr.size) {
        currentSum += arr[windowEnd]
        currentSum -= arr[windowsStart]
        if (currentSum.toDouble()/k >= threshold) {
            counter++
        }
        windowsStart++
        windowEnd++
    }
    return counter
}
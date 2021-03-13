package challenges.march2021

import java.util.HashMap

import kotlin.math.sqrt

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3670/
 */

//fun numFactoredBinaryTrees(arr: IntArray): Int {
//    arr.sort()
//    val map = mutableMapOf<Int, Long>()
//    val s = arr.toSet()
//    for ((index1, value1 ) in arr.withIndex()) {
//        val ways1 = map.getOrPut(value1) { 1 }
//        for (index2 in index1..arr.lastIndex) {
//            val value2 = arr[index2]
//            val ways2 = map.getOrPut(value2) { 1 }
//            val multiplication = value1 * value2
//            if (s.contains(multiplication)) {
//                var w = map.getOrDefault(multiplication, 1)
//                w += (ways2 * ways1) * if (value1 != value2) {
//                    2
//                } else {
//                    1
//                }
//                map[multiplication] = w
//            }
//        }
//    }
//    return ((map.values.fold(0L) { acc, l -> acc + l }) % 1000000007).toInt()
//}

fun numFactoredBinaryTrees(arr: IntArray): Int {
    arr.sort()
    var ans: Long = 0
    val fmap = HashMap<Int, Long>()
    for (num in arr) {
        var ways: Long = 1
        val lim = sqrt(num.toDouble())
        var j = 0
        var fA: Int = arr[0]
        while (fA <= lim) {
            if (num % fA != 0) {
                fA = arr[++j]
                continue
            }
            val fB = num / fA
            if (fmap.containsKey(fB)) ways += fmap[fA]!! * fmap[fB]!! * if (fA == fB) 1 else 2
            fA = arr[++j]
        }
        fmap[num] = ways
        ans = (ans + ways) % 1000000007
    }
    return ans.toInt()
}
package challenges.february2021

import java.util.*

/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3641/
 */
fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
    val treeSet = TreeSet<Pair<Int, Int>> { v1, v2 ->
        val comp = v1.second.compareTo(v2.second)
        if (comp == 0) {
            v1.first.compareTo(v2.first)
        } else {
            comp
        }
    }
    mat.foldIndexed(treeSet) { index, acc, arr ->
        acc.apply {
           add(index to arr.indexOfLast { e -> e != 0 } + 1)
        }
    }
    return treeSet.take(k).map {
        it.first
    }.toIntArray()
}
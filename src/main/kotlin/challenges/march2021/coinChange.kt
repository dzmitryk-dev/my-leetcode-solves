package challenges.march2021

import java.util.*

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3668/
 */
fun coinChange(coins: IntArray, amount: Int): Int {
    if (amount == 0) return 0

    coins.sortDescending()
    return bfs(sortedSetOf(amount), coins)
}

private tailrec fun bfs(target: SortedSet<Int>, candidates: IntArray, step: Int = 0): Int {
    if (target.isContainsZero()) return step
    if (target.isEmpty()) return -1
    val newTargets = candidates
        .flatMap { nominal ->
            target.map { t ->
                t - nominal
            }
        }.filterNot { it < 0 }
        .toSortedSet()
    return bfs(newTargets, candidates, step + 1)
}

private fun SortedSet<Int>.isContainsZero(): Boolean {
    for (i in this) {
        if (i == 0) {
            return true
        } else if (i > 0) {
            return false
        }
    }
    return false
}
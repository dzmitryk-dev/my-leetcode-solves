package challenges.august2021

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3837/
 */

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    fun permutation(candidates: List<Int>, sets: List<List<Int>> = emptyList()): List<List<Int>> {
        if (candidates.isEmpty()) return sets
        val result: MutableSet<List<Int>>  = mutableSetOf()
        for ((index, value)  in candidates.withIndex()) {
            val newCandidates = candidates.subList(index + 1, candidates.size)
            val newSets = if (sets.isEmpty()) {
                listOf(listOf(value))
            } else {
                sets.map { it + value }
            }
            result.addAll(sets)
            result.addAll(permutation(newCandidates, newSets))
        }
        return result.apply {
            add(emptyList())
        }.toList()
    }
    return permutation(nums.sorted().toList())
}
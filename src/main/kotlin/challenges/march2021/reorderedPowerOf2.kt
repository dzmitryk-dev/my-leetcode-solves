package challenges.march2021

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3679/
 */

fun reorderedPowerOf2(N: Int): Boolean {
    if (N.isPowOf2()) return true
    val digits = toDigits(N)
    return reorder(digits).any { it.isPowOf2() }
}

private fun Int.isPowOf2(): Boolean =
    Integer.bitCount(this) == 1

private tailrec fun toDigits(n: Int, acc: MutableList<Int> = mutableListOf()): List<Int> {
    return if (n == 0) {
        acc
    } else {
        toDigits(n / 10, acc.apply {
            add(0, n % 10)
        })
    }
}

private fun reorder(candidates: List<Int>, variant: Int = 0): List<Int> {
    return if (candidates.isEmpty()) {
        listOf(variant)
    } else {
        candidates.mapIndexed { index, i ->
            //Leading zero is forbidden
            if (variant == 0 && i == 0) {
                emptyList<Int>()
            } else {
                val newCandidates = candidates.filterIndexed { indx, _ -> indx != index  }
                reorder(newCandidates, variant * 10 + i)
            }
        }.flatten()
    }
}


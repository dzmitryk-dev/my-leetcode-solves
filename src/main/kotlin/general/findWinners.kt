package general

/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses
 */
fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val allLosers = mutableSetOf<Int>()
    val onlyWinners = mutableSetOf<Int>()
    val onlyOneLose = mutableSetOf<Int>()
    matches.forEach { (winner, loser) ->
        if(!allLosers.contains(winner)) {
            onlyWinners.add(winner)
        }
        if (allLosers.add(loser)) {
            onlyOneLose.add(loser)
        } else {
            onlyOneLose.remove(loser)
        }
        onlyWinners.remove(loser)
    }
    return listOf(
        onlyWinners.toList().sorted(),
        onlyOneLose.toList().sorted()
    )
}
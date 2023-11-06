package general.firstbadversion

/**
 * https://leetcode.com/problems/first-bad-version/
 */
class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        return search(n)
    }

    private tailrec fun search(guessedValue: Int, good: Int = 0, bad: Int = Int.MAX_VALUE): Int {
        if (bad - good == 1) return bad
        val isBad = isBadVersion(guessedValue)
        val newGuessedValue = if (isBad) {
            good + (guessedValue - good) / 2
        } else {
            guessedValue + (bad - guessedValue) / 2
        }
        val newGood = if (isBad) {
            good
        } else {
            guessedValue
        }
        val newBad = if (isBad) {
            guessedValue
        } else {
            bad
        }
        return search(
            guessedValue = newGuessedValue,
            good = newGood,
            bad = newBad,
        )
    }
}

abstract class VersionControl {

    var bad: Int = 0
    abstract fun firstBadVersion(n: Int): Int

    fun isBadVersion(version: Int): Boolean =
        version >= bad
}
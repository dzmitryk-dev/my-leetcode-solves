package general.firstbadversion

/**
 * https://leetcode.com/problems/first-bad-version/
 */
class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        return search(bad = n)
    }

    private tailrec fun search(good: Int = 0, bad: Int): Int {
        if (good + 1 == bad) return bad
        val guessedValue = good + (bad - good) / 2
        val isBad = isBadVersion(guessedValue)
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
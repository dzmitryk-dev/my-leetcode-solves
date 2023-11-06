package general.firstbadversion

/**
 * https://leetcode.com/problems/first-bad-version/
 */
class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var left = 0
        var right = n
        var candidate = n

        var isBad = false
        while (left <= right) {
            candidate = left + (right - left)/2
            isBad = isBadVersion(candidate)
            if (isBad) {
                right = candidate - 1
            } else {
                left = candidate + 1
            }
        }

        return if (isBad) candidate else candidate + 1
    }
}

abstract class VersionControl {

    var bad: Int = 0
    abstract fun firstBadVersion(n: Int): Int

    fun isBadVersion(version: Int): Boolean =
        version >= bad
}
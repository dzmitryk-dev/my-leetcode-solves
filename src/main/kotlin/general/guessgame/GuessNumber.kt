package general.guessgame

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
class Solution: GuessGame() {

    override fun guessNumber(n:Int): Int {
        return search(n)
    }

    private tailrec fun search(guessedValue: Int, left: Int = 1, right: Int = Int.MAX_VALUE): Int {
        val result = guess(guessedValue)
        return if(result == 0) {
            guessedValue
        } else {
            search(
                if (result > 0) {
                    guessedValue + (right - guessedValue)/2
                } else {
                    left + (guessedValue - left)/2
                },
                if (result > 0) {
                    guessedValue
                } else {
                    left
                },
                if (result > 0) {
                    right
                } else {
                    guessedValue
                }
            )
        }
    }
}

abstract class GuessGame {

    var pick: Int = 0

    /**
     * The API guess is defined in the parent class.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * fun guess(num:Int):Int {}
     */
    protected fun guess(num:Int):Int {
        return when {
            num > pick -> -1
            num == pick -> 0
            else -> 1
        }
    }

    abstract fun guessNumber(n: Int): Int
}
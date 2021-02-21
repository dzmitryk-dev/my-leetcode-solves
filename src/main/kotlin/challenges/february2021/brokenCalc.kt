package challenges.february2021

/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3647/
 */
fun brokenCalc(X: Int, Y: Int): Int {
    return when {
        X == Y -> 0
        Y < X -> X - Y
        else -> {
            var counter = 0
            var value: Int = Y
            while (value > X) {
                value = if (value % 2 == 0) {
                    value / 2
                } else {
                    value + 1
                }
                counter++
            }
            X - value + counter
        }
    }
}

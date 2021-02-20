package challenges.february2021

/**
 * https://leetcode.com/explore/featured/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3646/
 *
 * Arithmetic rules
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 */

private val romanToArabMapping = mapOf(
    'I' to 1, 'V' to 5, 'X' to 10, 'L' to 50,  'C' to 100, 'D' to 500, 'M' to 1000
)

fun romanToInt(s: String): Int {
    var result = 0
    var prevValue = 0
    var currentValue = 0
    val iterator = s.iterator()
    while (iterator.hasNext()) {
        currentValue = romanToArabMapping[iterator.nextChar()]!!
        val toAdd = if (
            prevValue == 1 && (currentValue == 5 || currentValue == 10) ||
            prevValue == 10 && (currentValue == 50 || currentValue == 100) ||
            prevValue == 100 && (currentValue == 500 || currentValue == 1000)
        ) {
            (currentValue - prevValue).also {
                currentValue = 0
            }
        } else {
            prevValue
        }
        result += toAdd
        prevValue = currentValue
    }
    return result + currentValue
}
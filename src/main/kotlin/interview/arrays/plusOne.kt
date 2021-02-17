package interview.arrays

fun plusOne(digits: IntArray): IntArray {
    var index = digits.lastIndex
    do {
        if (digits[index] < 9) {
            digits[index] += 1
            return digits
        } else {
            digits[index] = 0
            index--
        }
    } while (index >= 0)
    return if (index < 0) {
        return intArrayOf(1) + digits
    } else {
        digits
    }
}
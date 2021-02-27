package challenges.february2021

import kotlin.math.sign

/*
    https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3654/
 */

fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == 0) return 0
    if (divisor == 1) return dividend
    if (divisor == -1) {
        return if (dividend == Int.MIN_VALUE) {
            Int.MAX_VALUE
        } else {
            -dividend
        }
    }
    if (dividend == divisor) return 1
    if (dividend < 0 && divisor < 0 && -(dividend - divisor) < 0) {
        return 0
    } else if (dividend > 0 && divisor > 0 && dividend < divisor) {
        return 0
    } else if (dividend < 0 && divisor > 0 && dividend + divisor > 0) {
        return 0
    } else if (dividend > 0 && divisor < 0 && dividend + divisor < 0) {
        return 0
    }
    val resultSign = if (divisor.sign == dividend.sign) {
        1
    } else {
        -1
    }
    val result = divide(
        dividend,
        divisor,
        resultSign,
        0
    )
    return if (resultSign > 0) {
        result
    } else {
        -result
    }
}

private tailrec fun divide(dividend: Int, divisor: Int, resultSign: Int, step: Int): Int {
    val result = if (resultSign > 0) {
        dividend - divisor
    } else {
        dividend + divisor
    }
    return if (result.myMod() < divisor.myMod()) step + 1
    else divide(result, divisor, resultSign, step + 1)
}

private fun Int.myMod(): Int =
    if (this > 0) {
        this
    } else {
        -this
    }
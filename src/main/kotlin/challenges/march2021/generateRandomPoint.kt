package challenges.march2021

import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3675/
 */

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(radius, x_center, y_center)
 * var param_1 = obj.randPoint()
 */
class Solution(
    private val radius: Double,
    private val x_center: Double,
    private val y_center: Double
) {
    fun randPoint(): DoubleArray {
        val distance = sqrt(Math.random()) * radius
        val randomAngle = Math.random() * 2 * Math.PI
        val x = distance * cos(randomAngle)
        val y = distance * sin(randomAngle)
        return doubleArrayOf(x_center + x, y_center + y)
    }
}
package general

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/circle-and-rectangle-overlapping/
 */
fun checkOverlap(radius: Int, x_center: Int, y_center: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    // find closest rectangle point to circle center
    val dx = x_center - max(x1, min(x_center, x2))
    val dy = y_center - max(y1, min(y_center, y2))
    // find the intersection
    return (dx * dx + dy * dy) <= (radius * radius)
}
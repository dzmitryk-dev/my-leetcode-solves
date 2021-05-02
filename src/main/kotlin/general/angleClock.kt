package general

import java.lang.Double.max
import java.lang.Double.min

private const val MINUTE_ANGLE = 6
private const val HOUR_ANGLE = 30

/**
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 */
fun angleClock(hour: Int, minutes: Int): Double {
    val minuteAngle = (minutes * MINUTE_ANGLE).toDouble().normalize()
    val hourAngle = (hour * HOUR_ANGLE + (HOUR_ANGLE.toDouble()/60 * minutes)).normalize()
    return (max(minuteAngle, hourAngle) - min(minuteAngle, hourAngle)).toMinAngle()
}

private fun Double.toMinAngle(): Double =
    if (this >= 180.0) {
        360.0 - this
    } else {
        this
    }

private fun Double.normalize(): Double =
    if (this >= 360.0) {
        this - 360
    } else {
        this
    }
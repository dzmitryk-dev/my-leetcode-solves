package challenges.march2021

import kotlin.math.max

fun maxProfit(prices: IntArray, fee: Int): Int {
    val len: Int = prices.size
    var buying = 0
    var selling: Int = -prices[0]
    for (i in 1 until len) {
        buying = max(buying, selling + prices[i] - fee)
        selling = max(selling, buying - prices[i])
    }
    return buying
}
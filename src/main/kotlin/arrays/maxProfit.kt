package arrays

fun maxProfit(prices: IntArray): Int {
    var currentMinIndex = 0
    var currentMaxIndex = 0
    var profit = 0
    for (index in 1..prices.lastIndex) {
        val value = prices[index]

        if (prices[currentMinIndex] > value) {
            profit += (prices[currentMaxIndex] - prices[currentMinIndex])
            currentMinIndex = index
            currentMaxIndex = index
            continue
        }

        if(prices[currentMaxIndex] < value) {
            currentMaxIndex = index
            continue
        }

        if (prices[currentMaxIndex] > value && index > currentMaxIndex && currentMaxIndex > currentMinIndex) {
            profit += (prices[currentMaxIndex] - prices[currentMinIndex])
            currentMinIndex = index
            currentMaxIndex = index
            continue
        }
    }
    profit += (prices[currentMaxIndex] - prices[currentMinIndex])
    return profit
}
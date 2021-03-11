package challenges.march2021

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3668/
 */
fun coinChange(coins: IntArray, amount: Int): Int {
    if (amount == 0) return 0
    var counter = 0
    var amountRest = amount
    coins.sortDescending()
    for (nominal in coins) {
        val result = amountRest / nominal
        if (result > 0) {
            counter += result
            amountRest %= nominal
        }
    }
    return if (amountRest > 0) {
        -1
    } else {
        counter
    }
}
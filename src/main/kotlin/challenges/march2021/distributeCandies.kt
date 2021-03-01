package challenges.march2021

/*
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3657/
 */
fun distributeCandies(candyType: IntArray): Int {
    val maxCandies = candyType.size / 2
    return minOf(candyType.toSet().size, maxCandies)
}
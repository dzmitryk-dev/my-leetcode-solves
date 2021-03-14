package challenges.march2021

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3670/
 */
/*
  My solution
 */
fun numFactoredBinaryTrees(arr: IntArray): Int {
    arr.sort()
    val map = mutableMapOf<Int, Long>()
    val s = arr.toSet()
    for ((index1, value1 ) in arr.withIndex()) {
        var ways1 = map.getOrPut(value1) { 1 }
        if (index1 > 0) {
            for (index2 in index1 - 1 downTo 0) {
                val value2 = arr[index2]
                val ways2 = map.getOrPut(value2) { 1 }
                if (value1 % value2 == 0) {
                    val division = value1 / value2
                    if (s.contains(division)) {
                        val waysDivision = map.getOrDefault(division, 1)
                        ways1 += (ways2 * waysDivision)
                    }
                }
            }
            map[value1] = ways1
        }
    }
    return ((map.values.fold(0L) { acc, l -> acc + l }) % 1000000007).toInt()
}


/*
 * Solution from leetcode forum
 */
/*
fun numFactoredBinaryTrees(arr: IntArray): Int {
    arr.sort()
    var ans: Long = 0
    val fmap = HashMap<Int, Long>()
    for (num in arr) {
        var ways: Long = 1
        val lim = sqrt(num.toDouble())
        var j = 0
        var fA: Int = arr[0]
        while (fA <= lim) {
            if (num % fA != 0) {
                fA = arr[++j]
                continue
            }
            val fB = num / fA
            if (fmap.containsKey(fB)) ways += fmap[fA]!! * fmap[fB]!! * if (fA == fB) 1 else 2
            fA = arr[++j]
        }
        fmap[num] = ways
        ans = (ans + ways) % 1000000007
    }
    return ans.toInt()
}*/
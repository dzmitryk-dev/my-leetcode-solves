package interview.strings

/*
  https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/881/
 */

fun firstUniqChar(s: String): Int {
    if (s.isEmpty()) return -1
    val map = LinkedHashMap<Char, IntArray>()
    s.forEachIndexed { index, c ->
        map.compute(c) { _, old->
            old?.let { intArrayOf(*old, index) } ?: intArrayOf(index)
        }
    }
    return Iterable { map.iterator() }
        .firstOrNull { (_,arr) -> arr.size == 1 }
        ?.let { (_, arr) -> arr[0] }
        ?: -1
}
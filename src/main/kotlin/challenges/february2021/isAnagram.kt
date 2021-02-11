package challenges.february2021

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    fun countSymbols(str: String): Map<Char, Int> =
        str.fold(mutableMapOf()) { acc, c ->
            acc.apply {
                val prev = acc.getOrDefault(c, 0)
                acc[c] = prev + 1
            }
        }

    val map1 = countSymbols(s)
    val map2 = countSymbols(t)

    if (map1.size != map2.size) return false

    for ((key, value ) in map1.entries) {
        if (map2.getOrDefault(key, 0) != value) {
            return false
        }
    }
    return true
}
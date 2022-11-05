package general

/**
 * https://leetcode.com/problems/kth-distinct-string-in-an-array/
 */
fun kthDistinct(arr: Array<String>, k: Int): String {
    val filtered = mutableSetOf<String>()
    val handled = mutableSetOf<String>()
    for (s in arr) {
        if (!handled.contains(s)) {
            filtered.add(s)
            handled.add(s)
        } else {
            filtered.remove(s)
        }

    }
    return filtered.elementAtOrElse(k - 1) { "" }
}

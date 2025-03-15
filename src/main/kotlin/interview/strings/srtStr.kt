package interview.strings

fun strStr(haystack: String, needle: String): Int {
    if (needle.isEmpty()) return 0
    if (haystack.isEmpty()) return -1
    if (haystack.length < needle.length) return -1
    for (i in 0..haystack.length - needle.length) {
        if (haystack.substring(i, i + needle.length) == needle) return i
    }
    return -1
}
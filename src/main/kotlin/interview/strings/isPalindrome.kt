package interview.strings

// https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/883/

/*fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) {
        return true
    }
    val preparedString = s.toLowerCase().replace(Regex("\\W|_"), "")
    println("preparedString = $preparedString")
    return recSearch(preparedString)
}

private tailrec fun recSearch(chars: CharSequence): Boolean {
    println("recSearch. chars = $chars")
    if (chars.length <= 1) {
        return true
    }
    chars.first().isLetterOrDigit()
    return if (chars.first() == chars.last()) {
        recSearch(chars.subSequence(1, chars.lastIndex))
    } else {
        false
    }
}*/

/**
 * Fucking slowly
 * */
/*
tailrec fun isPalindrome(s: String): Boolean {
    println("s = $s")
    if (s.length <= 1) {
        println("s.length <= 1; return true")
        return true
    }
    val first = s.first().toLowerCase()
    if (!first.isLetterOrDigit()) {
        println("!first.isLetterOrDigit(); $first")
        return isPalindrome(s.substring(1))
    }
    val last = s.last().toLowerCase()
    if (!last.isLetterOrDigit()) {
        println("!last.isLetterOrDigit(), $last")
        return isPalindrome(s.substring(0, s.lastIndex))
    }
    if (last == first) {
        println("last == first; $last, $first")
        return isPalindrome(s.substring(1, s.lastIndex))
    }
    println("last != first; $last, $first")
    return false
}
*/
fun isPalindrome(s: String): Boolean {
    if (s.length <= 1) {
        // println("s.length <= 1; return true")
        return true
    }
    return recSearch(s, 0, s.lastIndex)
}

private tailrec fun recSearch(chars: CharSequence, firstIndex: Int, lastIndex: Int): Boolean {
    // println("recSearch. chars = ${chars.subSequence(firstIndex, lastIndex)}")
    if (lastIndex - firstIndex < 1) {
        return true
    }
    val first = chars[firstIndex]
    if (!first.isLetterOrDigit()) {
        return recSearch(chars, firstIndex+1, lastIndex)
    }
    val last = chars[lastIndex]
    if (!last.isLetterOrDigit()) {
        return recSearch(chars, firstIndex, lastIndex - 1)
    }
    return if (first.equals(last, true)) {
        recSearch(chars, firstIndex + 1, lastIndex - 1)
    } else {
        false
    }
}
package strings

fun reverseString(s: CharArray) {
    var index = 0
    var referenceIndex = s.lastIndex
    var temp: Char
    while (index <= referenceIndex) {
        temp = s[index]
        s[index] = s[referenceIndex]
        s[referenceIndex] = temp
        index++
        referenceIndex--
    }
}
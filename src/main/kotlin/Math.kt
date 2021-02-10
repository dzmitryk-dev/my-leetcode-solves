fun pow2(n : Int): Int {
    return if (n == 0) {
        1
    } else {
        var i = 1
        repeat(n) {
            i *= 2
        }
        i
    }
}
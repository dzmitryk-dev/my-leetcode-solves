fun IntArray.print(): String =
    this.joinToString("," , "[", "]")

inline fun <reified T> Array<T>.print(): String =
    this.joinToString("," , "[", "]")
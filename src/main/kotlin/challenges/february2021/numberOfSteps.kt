package challenges.february2021

fun numberOfSteps(num: Int): Int {
    if (num == 0) return 0
    val substractionsNum = Integer.bitCount(num) - 1
    val divisionsNum = Integer.SIZE - Integer.numberOfLeadingZeros(num)
    return substractionsNum + divisionsNum
}
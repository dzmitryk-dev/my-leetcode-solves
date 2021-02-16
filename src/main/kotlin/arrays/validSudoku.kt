package arrays

data class Point(
    val x: Int, val y:Int
)

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val map = mutableMapOf<Int, MutableSet<Point>>()
    board.forEachIndexed { indexY, chars ->
        chars.forEachIndexed { indexX, char ->
            if (char.isDigit()) {
                val number = Character.getNumericValue(char)
                val point = Point(indexX, indexY)
                val set = map.getOrPut(number) { mutableSetOf() }
                set.add(point)
            }
        }
    }
    for (coordinates in map.values) {
        if (coordinates.size > 1) {
            if (coordinates.size > 9) return false
            val conditions = listOf(
                coordinates.distinctBy { (x, _) -> x },
                coordinates.distinctBy { (_, y) -> y },
                coordinates.distinctBy { (x, y) -> Point(x / 3, y / 3) }
            )
            if(conditions.any { it.size != coordinates.size }) {
                return false
            }
        }
    }
    return true
}
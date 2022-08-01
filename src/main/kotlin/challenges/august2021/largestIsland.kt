package challenges.august2021

import kotlin.math.max

typealias Point = Pair<Int, Int>

val Point.x: Int
    get() = this.first

val Point.y: Int
    get() = this.second

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3835/
 */
fun largestIsland(grid: Array<IntArray>): Int {
    val n = grid.size
    var maxSize = 0
    val islands = mutableMapOf<Int, Int>()
    var islandId = 10
    for (x in 0 until n) {
        for (y in 0 until n) {
            if (grid[x][y] == 1) {
                val size = findIsland(grid, setOf(Point(x, y)), islandId)
                islands[islandId] = size
                maxSize = max(size, maxSize)
                islandId++
            }
        }
    }

    if (islands.isEmpty()) return 1

    for (x in 0 until n) {
        for (y in 0 until n) {
            if (grid[x][y] == 0) {
                val maxIslandSize = Point(x, y).nearest(n)
                    .filterNot { (x, y) -> grid[x][y] == 0 }
                    .map { (x, y) -> grid[x][y] }
                    .toSet()
                    .map { islands[it] ?: 0 }
                    .sum() + 1

                maxSize = max(maxIslandSize, maxSize)
            }
        }
    }

    return maxSize
}

private tailrec fun findIsland(
    grid: Array<IntArray>,
    points: Set<Point>,
    islandId: Int,
    islandSize: Int = 0
): Int {
    if (points.isEmpty()) {
        return islandSize
    }
    val handledPoints = points
        .filter { p -> grid[p.x][p.y] == 1 }
        .onEach { p -> grid[p.x][p.y] = islandId }

    val n = grid.size
    val newPoints = handledPoints.flatMap { p -> p.nearest(n) }
        .toSet()
    return findIsland(grid, newPoints, islandId, islandSize + handledPoints.size)
}

private fun Point.nearest(gridSize: Int): List<Point> =
    listOf(Point(x - 1, y), Point(x, y - 1), Point(x + 1, y), Point(x, y + 1))
        .filterNot { (px, py) -> px < 0 || py < 0 || px >= gridSize || py >= gridSize }
package challenges.february2021

/**
 * https://leetcode.com/explore/featured/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3638/
 */

data class Coordinate(
    val x: Int, val y: Int
)

val preparedArray = IntRange(-1, 1)
    .let { xrange ->
        val yrange = IntRange(- 1, 1)
        xrange.flatMap { x ->
            yrange.map { y -> intArrayOf(x, y) }
        }.filterNot { (x, y) -> x == 0 && y == 0}
    }

fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    if (grid[0][0] == 1) return -1
    val gridSize = grid.size
    val start = Coordinate(0,0)
    val finish = Coordinate(gridSize - 1, gridSize - 1)
    return findPath(grid, finish, 0, setOf(start) )
}

tailrec fun findPath(
    grid: Array<IntArray>,
    finish: Coordinate,
    step: Int,
    candidates: Collection<Coordinate>,
    visitedPoints: MutableSet<Coordinate> = mutableSetOf()
): Int {
    if (finish in candidates) return step + 1
    val newCandidates = candidates.flatMap { coordinate ->
        findCandidates(grid, coordinate, visitedPoints)
    }
        .toSet()
    if (newCandidates.isEmpty()) return -1
    visitedPoints.addAll(candidates)
    return findPath(grid, finish, step + 1, newCandidates, visitedPoints)
}

fun findCandidates(grid: Array<IntArray>, coord: Coordinate, visitedPoints: Collection<Coordinate>): List<Coordinate> {
    val gridSize = grid.size
    return preparedArray
        .map { (x, y) -> Coordinate(x + coord.x, y + coord.y) }
        .filter { (x, y) -> x >= 0 && y >= 0 && x < gridSize && y < gridSize}
        .filter { (x, y) -> grid[y][x] != 1 }
        .filterNot { it in visitedPoints }
}

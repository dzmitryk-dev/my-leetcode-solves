package challenges.march2021

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3677/
 */

fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    tailrec fun bfs(roomToVisit: MutableSet<Int>, visitedRooms: MutableSet<Int>) {
        if (roomToVisit.isEmpty()) return
        val roomNumber = roomToVisit.first()
        val keys = rooms[roomNumber]
        roomToVisit.addAll(keys.filterNot { it in visitedRooms })
        roomToVisit.remove(roomNumber)
        visitedRooms.add(roomNumber)
        bfs(roomToVisit, visitedRooms)
    }
    val roomToVisit = mutableSetOf(0)
    val visitedRooms = mutableSetOf<Int>()
    bfs(roomToVisit, visitedRooms)
    return visitedRooms.size == rooms.size
}
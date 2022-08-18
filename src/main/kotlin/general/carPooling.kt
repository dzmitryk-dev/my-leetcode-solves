/**
 * https://leetcode.com/problems/car-pooling/
 */
package general

typealias Event = Pair<Int, Int>

val Event.position: Int
    get() = this.first

val Event.action: Int
    get() = this.second

fun createEvent(position: Int, action: Int): Event = Pair(position, action)

fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
    val events = trips.fold(mutableListOf<Event>()) { acc, (passengers, from, to) ->  acc.apply {
        add(createEvent(from, passengers))
        add(createEvent(to, -passengers))
    } }
    events.sortWith { o1, o2 ->
        val v = o1.position - o2.position
        if (v == 0) {
            o1.action
        } else {
            v
        }
    }
    var acc = 0
    for (event in events) {
        acc += event.action
        if (acc > capacity) {
            return false
        }
    }
    return true
}
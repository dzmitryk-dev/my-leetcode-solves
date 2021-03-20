package challenges.march2021

import java.util.*

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */

typealias ID = Int

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3678/
 */

class UndergroundSystem() {

    private class RouteCompositeKey(
        station1: String,
        station2: String
    ) {
        private val set = sortedSetOf(station1, station2)

        override fun equals(other: Any?): Boolean {
            return if (other is RouteCompositeKey) {
                (set.clone() as SortedSet<*>).apply {
                    removeAll(other.set)
                }.isEmpty()
            } else {
                false
            }
        }

        override fun hashCode(): Int {
            return set.hashCode()
        }
    }

    private data class TravelInfo(
        val stationName: String,
        val startTime: Int
    )

    private val travelInfo = mutableMapOf<ID, TravelInfo>()
    private val routeTime = mutableMapOf<RouteCompositeKey, MutableList<Int>>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        travelInfo[id] = TravelInfo(stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val info = travelInfo.remove(id)
        val key = RouteCompositeKey(info!!.stationName, stationName)
        routeTime.compute(key) { _, list->
            (list ?: mutableListOf()).apply {
                add(t - info.startTime)
            }
        }
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        return routeTime[RouteCompositeKey(startStation, endStation)]!!.let {
            it.reduce { a, b -> a + b }.toDouble() / it.size
        }
    }

}
package challenges.march2021

/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3663/
 */

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
class MyHashMap {

    private data class Entry(
        val key: Int,
        val value: Int
    )

    /** Initialize your data structure here. */
    private var keys = Array<MutableList<Entry>>(32) { mutableListOf() }

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        val entry = Entry(key, value)
        val index = key.hashCode() % keys.size
        with(keys[index]) {
            val e = find { (k, _) -> k == key }
            if (e != null) {
                remove(e)
            }
            add(entry)
            sortBy { (key, _) -> key }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        val index = key.hashCode() % keys.size
        return with(keys[index]) {
            val e = find { (k, _) -> k == key }
            e?.value ?: return -1
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        val index = key.hashCode() % keys.size
        with(keys[index]) {
            removeIf { (k, _) -> k == key }
        }
    }
}
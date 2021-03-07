package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MyHashMapTest {

    @Test
    fun testMyHashMap() {
        val hashMap = MyHashMap()
        hashMap.put(1, 1)
        hashMap.put(2, 2)

        Assertions.assertEquals(1, hashMap.get(1)) // returns 1
        Assertions.assertEquals(-1, hashMap.get(3)) // returns -1 (not found)

        hashMap.put(2, 1) // update the existing value
        Assertions.assertEquals(1, hashMap.get(2)) // returns 1

        hashMap.remove(2) // remove the mapping for 2
        Assertions.assertEquals(-1, hashMap.get(2)) // returns -1 (not found)
    }
}
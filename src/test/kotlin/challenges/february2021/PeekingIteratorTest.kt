package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PeekingIteratorTest {

    @Test
    fun test() {
        val data = listOf(1, 2, 3)
        val testIterator = PeekingIteratorImpl(data.iterator())

        Assertions.assertEquals(1, testIterator.next())
        Assertions.assertEquals(2, testIterator.peek())
        Assertions.assertEquals(true, testIterator.hasNext())

        Assertions.assertEquals(2, testIterator.next())
        Assertions.assertEquals(3, testIterator.peek())
        Assertions.assertEquals(true, testIterator.hasNext())

        Assertions.assertEquals(3, testIterator.next())
        Assertions.assertEquals(false, testIterator.hasNext())

    }


}
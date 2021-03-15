package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TinyURLTest {

    val testCodec = Codec()

    val input = "https://leetcode.com/problems/design-tinyurl"

    @Test
    fun test1() {
        val encoded = testCodec.encode(input)
        val decoded = testCodec.decode(encoded)
        Assertions.assertEquals(input, decoded)
    }

    @Test
    fun test2() {
        val encoded1 = testCodec.encode(input)
        val encoded2 = testCodec.encode(input)
        Assertions.assertEquals(encoded1, encoded2)
    }
}
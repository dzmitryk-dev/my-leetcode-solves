package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import print

class FreqStackTest {

    private lateinit var freqStack: FreqStack

    @BeforeEach
    fun setup() {
        freqStack = FreqStack()
    }

    @Test
    fun testFreqStack() {
        listOf(5, 7, 5, 7, 4, 5).forEach {
            freqStack.push(it)
        }
        val poppedArray = mutableListOf<Int>().also { list ->
            repeat(4) {
                list.add(freqStack.pop())
            }
        }.toIntArray()
        val expected = intArrayOf(5,7,5,4)
        Assertions.assertArrayEquals(
            expected,
            poppedArray,
            "Popped arrays should be ${expected.print()} but was ${poppedArray.print()}"
        )

    }
}
package general

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CanBeIncreasingTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun test(testCase: TestCase) {
        val actual = canBeIncreasing(testCase.input)
        assertEquals(testCase.expected, actual,
            "For {$testCase} actual value was $actual")
    }

    companion object {

        data class TestCase(
            val input: IntArray,
            val expected: Boolean
        ) {
            override fun toString(): String =
                "input = ${input.contentToString()}, expected = $expected"
        }

        @JvmStatic
        fun provideTestCases() = listOf(
            TestCase(intArrayOf(1,2,10,5,7), true),
            TestCase(intArrayOf(2,3,1,2), false),
            TestCase(intArrayOf(1, 1, 1), false),
            TestCase(intArrayOf(1, 1), true),
            TestCase(intArrayOf(100, 21, 100), true),
            TestCase(intArrayOf(105,924,32,968), true),
            TestCase(intArrayOf(1,2,3,4,10,5,5), false)
        )
    }
}
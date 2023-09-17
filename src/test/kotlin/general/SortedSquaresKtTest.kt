package general

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SortedSquaresKtTest {

    companion object {
        data class TestCase(
            val input: IntArray,
            val expected: IntArray
        )

        @JvmStatic
        fun provideTestCases() = listOf(
            TestCase(
                input = intArrayOf(-4,-1,0,3,10),
                expected = intArrayOf(0,1,9,16,100)
            ),
            TestCase(
                input = intArrayOf(-7,-3,2,3,11),
                expected = intArrayOf(4,9,9,49,121)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun test(testCase: TestCase) {
        val actual = sortedSquares(testCase.input)
        assertArrayEquals(testCase.expected, actual)
    }
}
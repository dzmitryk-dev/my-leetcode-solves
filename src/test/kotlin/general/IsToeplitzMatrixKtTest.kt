package general

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class IsToeplitzMatrixKtTest {

    companion object {

        data class TestCase(
            val matrix: Array<IntArray>,
            val expected: Boolean
        )

        @JvmStatic
        fun provideTestCases() = listOf(
            TestCase(
                matrix = arrayOf(
                    intArrayOf(1,2,3,4),
                    intArrayOf(5,1,2,3),
                    intArrayOf(9,5,1,2)
                ),
                expected = true
            ),
            TestCase(
                matrix = arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 2)
                ),
                expected = false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun test(testCase: TestCase) {
        val actual = isToeplitzMatrix(testCase.matrix)
        assertEquals(testCase.expected, actual)
    }
}
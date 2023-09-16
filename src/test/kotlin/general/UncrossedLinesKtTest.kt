package general

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class UncrossedLinesKtTest {

    companion object {

        class TestCase(
            val num1: IntArray,
            val num2: IntArray,
            val expected: Int
        )

        @JvmStatic
        fun provideTestCases() = listOf(
            TestCase(
                num1 = intArrayOf(1, 4, 2),
                num2 = intArrayOf(1, 2 ,4),
                expected = 2
            ),
            TestCase(
                num1 = intArrayOf(2,5,1,2,5),
                num2 = intArrayOf(10,5,2,1,5,2),
                expected = 3,
            ),
            TestCase(
                num1 = intArrayOf(1,3,7,1,7,5),
                num2 = intArrayOf(1,9,2,5,1),
                expected = 2
            ),
            TestCase(
                num1 = intArrayOf(1, 4, 2, 4),
                num2 = intArrayOf(1, 2 ,4),
                expected = 3
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun test(testCase: TestCase) {
//        val actual = maxUncrossedLines(testCase.num1, testCase.num2)
//        assertEquals(testCase.expected, actual) {
//            "maxUncrossedLines for ${testCase.num1} and ${testCase.num2} should be ${testCase.expected} but was $actual"
//        }
    }
}
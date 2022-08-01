package general

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NumberOfSubarraysTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun test(testCase: TestCase) {
        val actual = numOfSubarrays(testCase.inputArray, testCase.k, testCase.threshold)
        assertEquals(testCase.expected, actual,
            "For $testCase numOfSubarrays was $actual but should be ${testCase.expected}")
    }

    companion object {
        data class TestCase(
            val inputArray: IntArray,
            val k: Int,
            val threshold: Int,
            val expected: Int
        ) {
            override fun toString(): String =
                "inputArray=${inputArray.contentToString()}; k=$k, threshold=$threshold; expected=$expected"
        }

        @JvmStatic
        fun provideTestCases() = listOf(
            TestCase(
                inputArray = intArrayOf(2,2,2,2,5,5,5,8),
                k = 3,
                threshold = 4,
                expected = 3
            ),
            TestCase(
                inputArray = intArrayOf(11,13,17,23,29,31,7,5,2,3),
                k = 3,
                threshold = 5,
                expected =  6
            )
        )
    }
}
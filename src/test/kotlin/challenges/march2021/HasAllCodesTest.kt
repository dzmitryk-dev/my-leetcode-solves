package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class HasAllCodesTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = hasAllCodes(testData.s, testData.k)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "hasAllCodes for ${testData.s}, ${testData.k} should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val s: String,
            val k: Int,
            val expected: Boolean
        )

        @JvmStatic
        fun provideTestData() = listOf(
            /*
            Example 1:
            Input: s = "00110110", k = 2
            Output: true
            Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indicies 0, 1, 3 and 2 respectively.
             */
            TestData(s = "00110110", k = 2, expected = true),
            /*
            Example 2:
            Input: s = "00110", k = 2
            Output: true
             */
            TestData(s = "00110", k = 2, expected = true),
            /*
            Example 3:
            Input: s = "0110", k = 1
            Output: true
            Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.
            */
            TestData(s = "0110", k = 1, expected = true),
            /*
            Example 4:
            Input: s = "0110", k = 2
            Output: false
            Explanation: The binary code "00" is of length 2 and doesn't exist in the array.
            */
            TestData(s = "0110", k = 2, expected = false),
            /*
            Example 5:
            Input: s = "0000000001011100", k = 4
            Output: false
             */
            TestData(s = "0000000001011100", k = 4, expected = false),
        )
    }
}
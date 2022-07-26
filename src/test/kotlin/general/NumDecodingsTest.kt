package general

import numDecodings
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NumDecodingsTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestCase) {
        val actual = numDecodings(testData.input)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "numUniqueEmails for ${testData.input} should be ${testData.expected} but wa $actual"
        )
    }

    companion object {

        data class TestCase(
            val input: String,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
            /*
                Example 1:
                Input: s = "12"
                Output: 2
                Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
            */
            TestCase("12", 2),
            /*
                Example 2:
                Input: s = "226"
                Output: 3
                Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
             */
            TestCase("226", 3),
            /*
                Example 3:
                Input: s = "06"
                Output: 0
                Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
             */
            TestCase("06", 0),
            TestCase("10", 1),
            TestCase("111111111111111111111111111111111111111111111", 1836311903)
        )

    }


}
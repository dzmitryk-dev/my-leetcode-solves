package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class RomanToIntTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = romanToInt(testData.input)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "reverseString for ${testData.input}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val input: String,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
            // Example 1:
            // Input: s = "III"
            // Output: 3
            TestData("III", 3),
            // Example 2:
            // Input: s = "IV"
            // Output: 4
            TestData("IV", 4),
            // Example 3:
            // Input: s = "IX"
            // Output: 9
            TestData("IX", 9),
            // Example 4:
            // Input: s = "LVIII"
            // Output: 58
            // Explanation: L = 50, V= 5, III = 3.
            TestData("LVIII", 58),
            // Example 5:
            // Input: s = "MCMXCIV"
            // Output: 1994
            // Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
            TestData("MCMXCIV", 1994)
        )
    }
}
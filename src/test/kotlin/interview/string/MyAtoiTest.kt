package interview.string

import interview.strings.myAtoi
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MyAtoiTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = myAtoi(testData.input)
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
            // Input: s = "42"
            // Output: 42
            TestData("42", 42),
            // Input: s = "   -42"
            // Output: -42
            TestData("   -42", -42),
            // Input: s = "4193 with words"
            // Output: 4193
            TestData("4193 with words", 4193),
            // Input: s = "words and 987"
            // Output: 0
            TestData("words and 987", 0),
            // Input: s = "-91283472332"
            // Output: -2147483648
            TestData("-91283472332", -2147483648),
            // Input: s = "+-12"
            // Output: 0
            TestData("+-12", 0),
            // Input: s = "9223372036854775808"
            // Output: 2147483647
            TestData("9223372036854775808", 2147483647),
        )
    }
}
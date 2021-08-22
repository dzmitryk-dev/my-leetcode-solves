package general

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ValidParenthesesTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = isValidParentheses(testData.s)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "isValidParentheses for ${testData.s} should be ${testData.expected} but wa ${actual}"
        )
    }

    companion object {

        data class TestData(
            val s: String,
            val expected: Boolean
        )

        @JvmStatic
        fun provideTestData() = listOf(
//            Example 1:
//            Input: s = "()"
//            Output: true
            TestData("()", true),
//            Example 2:
//            Input: s = "()[]{}"
//            Output: true
            TestData("()[]{}", true),
//            Example 3:
//            Input: s = "(]"
//            Output: false
            TestData("(]", false),
//            Example 4:
//            Input: s = "([)]"
//            Output: false
            TestData("([)]", false),
//            Example 5:
//            Input: s = "{[]}"
//            Output: true
            TestData("{[]}", true),
        )
    }
}
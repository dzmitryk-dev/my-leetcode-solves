package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ScoreOfParenthesisTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = scoreOfParentheses(testData.input1)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "scoreOfParentheses for ${testData.input1}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val input1: String,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
//            Example 1:
//            Input: "()"
//            Output: 1
            TestData("()", 1),
//            Example 2:
//            Input: "(())"
//            Output: 2
            TestData("(())", 2),
//            Example 3:
//            Input: "()()"
//            Output: 2
            TestData("()()",2),
//            Example 4:
//            Input: "(()(()))"
//            Output: 6
            TestData("(()(()))",6)
        )
    }

}
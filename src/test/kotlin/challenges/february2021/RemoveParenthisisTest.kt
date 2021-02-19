package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class RemoveParenthisisTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = minRemoveToMakeValid(testData.input)
        Assertions.assertTrue(
            { testData.acceptable.any { it == actual }},
            "minRemoveToMakeValid for ${testData.input} " +
                    "should be ${testData.acceptable.joinToString(",", "[", "]") { it }} " +
                    "but was ${actual}}"
        )
    }

    companion object {

        data class TestData(
            val input: String,
            val acceptable: List<String>
        ) {
            override fun toString(): String {
                return "$input ${acceptable.joinToString(",", "[", "]") { it }}"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            // Example 1:
            // Input: s = "lee(t(c)o)de)"
            // Output: "lee(t(c)o)de"
            // "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
            TestData("lee(t(c)o)de)", listOf("lee(t(c)o)de","lee(t(co)de)","lee(t(c)ode)")),
            // Example 2:
            // Input: s = "a)b(c)d"
            // Output: "ab(c)d"
            TestData("a)b(c)d", listOf("ab(c)d")),
            // Example 3:
            // Input: s = "))(("
            // Output: ""
            // Explanation: An empty string is also valid.
            TestData("))((", listOf("")),
            // Example 4:
            // Input: s = "(a(b(c)d)"
            // Output: "a(b(c)d)"
            TestData("(a(b(c)d)", listOf("a(b(c)d)")),
        )
    }


}
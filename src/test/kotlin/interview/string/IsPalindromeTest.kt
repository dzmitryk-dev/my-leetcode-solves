package interview.string

import interview.strings.isPalindrome
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class IsPalindromeTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = isPalindrome(testData.input)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "isPalindrome for ${testData.input}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val input: String,
            val expected: Boolean
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData("A man, a plan, a canal: Panama", true),
            TestData("ab_a", true),
            TestData("ab", false)
        )
    }
}
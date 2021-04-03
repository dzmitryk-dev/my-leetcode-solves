package general

import lengthOfLongestSubstring
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LengthOfLongestSubstringTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = lengthOfLongestSubstring(testData.s)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "lengthOfLongestSubstring for ${testData.s} should be ${testData.expected} but wa ${actual}"
        )
    }

    companion object {

        data class TestData(
            val s: String,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData("abcabcbb", 3),
            TestData("bbbbb", 1),
            TestData("pwwkew", 3),
            TestData("", 0),
            TestData("dvdf", 3),
            TestData(" ", 1),
            TestData("a", 1),
            TestData("au", 2),
        )
    }
}
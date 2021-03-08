package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class RemovePalindromeSubTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = removePalindromeSub(testData.s)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "removePalindromeSub for ${testData.s}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val s: String,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
            /*
                Example 1:
                Input: s = "ababa"
                Output: 1
                Explanation: String is already palindrome
            */
            TestData("ababa", 1),
            // Example 2:
            // Input: s = "abb"
            // Output: 2
            // Explanation: "abb" -> "bb" -> "".
            // Remove palindromic subsequence "a" then "bb".
            TestData("abb", 2),
            /*
                Example 3:
                Input: s = "baabb"
                Output: 2
                Explanation: "baabb" -> "b" -> "".
                Remove palindromic subsequence "baab" then "b".
            */
            TestData("baabb", 2),
            /*
                 Example 4:
                 Input: s = ""
                 Output: 0
             */
            TestData("", 0),
            TestData("bbaabaaa", 2),
            TestData("abbaaaab", 2)
        )
    }
}
package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class MinimumLengthEncodingTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = minimumLengthEncoding(testData.words)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "missingNumber for ${testData.words.print()}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val words: Array<String>,
            val expected: Int
        ) {
            override fun toString(): String {
                return "${words.print()}, $expected"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            // Input: words = ["time", "me", "bell"]
            // Output: 10
            // Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
            // words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is underlined in "time#bell#"
            // words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is underlined in "time#bell#"
            // words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is underlined in "time#bell#"
            TestData(arrayOf("time", "me", "bell"), 10),
            // Input: words = ["t"]
            // Output: 2
            // Explanation: A valid encoding would be s = "t#" and indices = [0].
            TestData(arrayOf("t"), 2),
            TestData(arrayOf("me", "time"), 5),
            TestData(arrayOf("feipyxx", "e"), 10)
        )
    }
}
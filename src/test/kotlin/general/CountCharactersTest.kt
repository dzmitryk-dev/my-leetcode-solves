package general

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class CountCharactersTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = countCharacters(testData.words, testData.chars)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "countCharacters for ${testData.words.print()}, ${testData.chars} should be ${testData.expected} but wa $actual"
        )
    }

    companion object {

        data class TestData(
            val words: Array<String>,
            val chars: String,
            val expected: Int
        ) {
            override fun toString(): String =
                "${words.print()}, $chars, $expected"
        }

        @JvmStatic
        fun provideTestData() = listOf(
            // Example 1:
            // Input: words = ["cat","bt","hat","tree"], chars = "atach"
            // Output: 6
            // Explanation:
            // The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
            TestData(arrayOf("cat","bt","hat","tree"), "atach", 6),
            // Example 2:
            // Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
            // Output: 10
            // Explanation:
            // The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
            TestData(arrayOf("hello","world","leetcode"), "welldonehoneyr", 10)
        )
    }
}
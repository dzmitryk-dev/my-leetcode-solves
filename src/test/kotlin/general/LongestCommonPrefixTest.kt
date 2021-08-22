package general

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class LongestCommonPrefixTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = longestCommonPrefix(testData.words)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "longestCommonPrefix for ${testData.words.print()} should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val words: Array<String>,
            val expected: String
        ) {
            override fun toString(): String =
                "${words.print()}, $expected"
        }

        @JvmStatic
        fun provideTestData() = listOf(
//            Example 1:
//            Input: strs = ["flower","flow","flight"]
//            Output: "fl"
            TestData(arrayOf("flower","flow","flight"), "fl"),
//            Example 2:
//            Input: strs = ["dog","racecar","car"]
//            Output: ""
            TestData(arrayOf("dog","racecar","car"), ""),
        )
    }
}
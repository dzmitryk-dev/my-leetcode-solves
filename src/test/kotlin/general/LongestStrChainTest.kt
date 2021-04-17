package general

import longestStrChain
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class LongestStrChainTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = longestStrChain(testData.words)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "longestStrChain for ${testData.words.print()} should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val words: Array<String>,
            val expected: Int
        ) {
            override fun toString(): String =
                "${words.print()}, $expected"
        }

        @JvmStatic
        fun provideTestData() = listOf(
            /*
             Input: words = ["a","b","ba","bca","bda","bdca"]
             Output: 4
             Explanation: One of the longest word chain is "a","ba","bda","bdca".
            */
            TestData(arrayOf("a","b","ba","bca","bda","bdca"), 4),
            TestData(arrayOf("xbc","pcxbcf","xb","cxbc","pcxbc"), 5),
            TestData(arrayOf("abcd","dbqca"),1)
        )
    }
}
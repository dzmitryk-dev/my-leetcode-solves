package interview.string

import interview.strings.strStr
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class StrStrTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val result = strStr(testData.haystack, testData.needle)
        assert(result == testData.expected) {
            "strStr for ${testData.haystack} ${testData.needle}, should be ${testData.expected} but was $result"
        }
    }

    companion object {

        data class TestData(
            val haystack: String,
            val needle: String,
            val expected: Int
        ) {
            override fun toString(): String {
                return "$haystack $needle $expected"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(haystack = "sadbutsad", needle = "sad", expected = 0),
            TestData(haystack = "leetcode", needle = "leeto", expected = -1),
            TestData(haystack = "butsadbutsad", needle = "sad", expected = 3),
        )
    }
}
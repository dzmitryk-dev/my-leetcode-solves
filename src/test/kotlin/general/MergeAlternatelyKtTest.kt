package general

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MergeAlternatelyKtTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun test(testCase: TestCase) {
        val actual = mergeAlternately(testCase.word1, testCase.word2)
        assertEquals(testCase.expected, actual,
            "For mergeAlternately(${testCase.word1}, ${testCase.word2}) expected ${testCase.expected} but was $actual")
    }

    companion object {

        data class TestCase(
            val word1: String,
            val word2: String,
            val expected: String
        )

        @JvmStatic
        fun provideTestCases() = listOf(
            TestCase(
                word1 = "abc",
                word2 = "pqr",
                expected = "apbqcr"
            ),
            TestCase(
                word1 = "ab",
                word2 = "pqrs",
                expected = "apbqrs"
            ),
            TestCase(
                word1 = "abcd",
                word2 = "pq",
                expected = "apbqcd"
            )
        )

    }

}
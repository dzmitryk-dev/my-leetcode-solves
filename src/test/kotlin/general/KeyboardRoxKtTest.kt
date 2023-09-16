package general

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class KeyboardRoxKtTest {

    companion object {
        data class TestCase(
            val input: Array<String>,
            val expected: Array<String>
        )

        @JvmStatic
        fun provideTestCases() = listOf(
            TestCase(
                input = arrayOf("Hello","Alaska","Dad","Peace"),
                expected = arrayOf("Alaska","Dad")
            ),
            TestCase(
                input = arrayOf("omk"),
                expected = emptyArray(),
            ),
            TestCase(
                input = arrayOf("adsdf","sfd"),
                expected = arrayOf("adsdf","sfd")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun test(testCase: TestCase) {
        val actual = findWords(testCase.input)
        assertArrayEquals(testCase.expected, actual) {
            "findWords for ${testCase.input.contentDeepToString()} should return ${testCase.expected.contentDeepToString()} but was ${actual.contentDeepToString()}"
        }
    }
}
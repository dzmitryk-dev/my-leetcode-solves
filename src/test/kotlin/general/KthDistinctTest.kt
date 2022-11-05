package general

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class KthDistinctTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testCase: TestCase) {
        val actual = kthDistinct(testCase.arr, testCase.k)
        Assertions.assertEquals(
            testCase.expected,
            actual,
            "kthDistinct for {$testCase} was $actual"
        )
    }

    companion object {
        data class TestCase(
            val arr: Array<String>,
            val k: Int,
            val expected: String,
        ) {
            override fun toString(): String =
                "data = ${arr.contentDeepToString()}, k = $k, expected = $expected"
        }

        @JvmStatic
        fun provideTestData() =
            listOf(
                TestCase(arr = arrayOf("d","b","c","b","c","a"), k = 2, expected = "a"),
                TestCase(arr = arrayOf("aaa","aa","a"), k = 1, expected = "aaa"),
                TestCase(arr = arrayOf("a","b","a"), k = 3, expected = ""),
            )
    }
}
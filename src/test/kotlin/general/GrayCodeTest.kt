package general

import grayCode
import org.junit.jupiter.api.Assertions

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class GrayCodeTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testCase: TestCase) {
        val actual = grayCode(testCase.n)

        Assertions.assertTrue({ testCase.expected.any { it == actual } },
            "$actual was not found in list of ${testCase.expected} values")
    }

    companion object {

        data class TestCase(
            val n: Int,
            val expected: List<List<Int>>
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestCase(2,
                listOf(
                    listOf(0,1,3,2),
                    listOf(0,2,3,1)
                )
            ),
            TestCase(
                1,
                listOf(listOf(0, 1))
            ),
            TestCase(
                3,
                listOf(listOf(0,1,3,2,6,7,5,4))
            )
        )
    }
}
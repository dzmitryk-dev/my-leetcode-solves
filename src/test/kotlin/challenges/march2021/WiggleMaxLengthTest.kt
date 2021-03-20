package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class WiggleMaxLengthTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = wiggleMaxLength(testData.numbers)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "wiggleMaxLength for ${testData.numbers.print()}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val numbers: IntArray,
            val expected: Int
        ) {
            override fun toString(): String =
                "${numbers.print()}, $expected"
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(intArrayOf(1,7,4,9,2,5), 6),
            TestData(intArrayOf(1,17,5,10,13,15,10,5,16,8), 7),
            TestData(intArrayOf(1,2,3,4,5,6,7,8,9), 2),
            TestData(intArrayOf(5,5,5,5,5,5), 1),
            TestData(intArrayOf(3,3,3,2,5), 3)
        )
    }
}
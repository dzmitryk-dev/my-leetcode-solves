package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class MaxProfitTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData:TestData) {
        val actual = maxProfit(testData.prices, testData.fee)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "maxProfit for ${testData.prices.print()}, ${testData.fee} should be ${testData.expected}"
        )
    }

    companion object {

        data class TestData(
            val prices: IntArray,
            val fee: Int,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(intArrayOf(1,3,2,8,4,9), 2, 8),
            TestData(intArrayOf(1,3,7,5,10,3), 3, 6),
        )
    }
}
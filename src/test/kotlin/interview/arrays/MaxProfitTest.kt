package interview.arrays

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class MaxProfitTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: Pair<IntArray, Int>) {
        val data = testData.first
        val expected = testData.second
        val actual = maxProfit(data)
        Assertions.assertEquals(
            expected,
            actual,
            "singleNumber for ${data.print()} should be $expected"
        )
    }

    companion object {
        @JvmStatic
        fun provideTestData() = listOf(
            intArrayOf(7,1,5,3,6,4) to 7,
            intArrayOf(1,2,3,4,5) to 4,
            intArrayOf(7,6,4,3,1) to 0,
            intArrayOf(2, 4, 1) to 2
        )
    }
}
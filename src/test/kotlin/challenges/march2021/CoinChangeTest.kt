package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class CoinChangeTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = coinChange(testData.coins, testData.amount)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "coinChange for ${testData.coins.print()}, ${testData.amount} should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val coins: IntArray,
            val amount: Int,
            val expected: Int
        ) {
            override fun toString(): String =
                "${coins.print()}, $amount, $expected"
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(intArrayOf(1, 2, 5), 11, 3),
            TestData(intArrayOf(2), 3, -1),
            TestData(intArrayOf(1), 0, 0),
            TestData(intArrayOf(1), 1, 1),
            TestData(intArrayOf(1), 2, 2),
            TestData(intArrayOf(2,5,10,1), 27, 4),
            TestData(intArrayOf(186,419,83,408),6249, 20),
        )
    }
}
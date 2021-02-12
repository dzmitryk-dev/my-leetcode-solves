package arrays

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class TwoSumTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val data = testData.data.clone()
        val expected = testData.expected
        val actual = twoSum(data, testData.target)
        Assertions.assertArrayEquals(
            expected.sortedArray(),
            actual.sortedArray(),
            "twoSum for ${testData.data.print()} ${testData.target} should be ${expected.print()} but wa ${actual.print()}"
        )
    }

    companion object {

        data class TestData(
            val data: IntArray,
            val target: Int,
            val expected: IntArray
        ) {

            override fun toString(): String {
                return "${data.print()}, $target, ${expected.print()}"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(intArrayOf(2,7,11,15), 9, intArrayOf(0, 1)),
            TestData(intArrayOf(3,2,4), 6, intArrayOf(1, 2)),
            TestData(intArrayOf(3, 3), 6, intArrayOf(0, 1)),
            TestData(intArrayOf(3, 2, 3), 6, intArrayOf(0, 2)),
            TestData(intArrayOf(-3,4,3,90), 0, intArrayOf(0, 2)),
        )
    }
}
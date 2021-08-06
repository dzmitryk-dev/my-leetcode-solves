package general

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class FindMedianSortedArraysTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = findMedianSortedArrays(testData.num1, testData.num2)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "findMedianSortedArrays for ${testData.num1.print()}, ${testData.num2.print()} should be ${testData.expected} but wa $actual"
        )
    }

    companion object {

        data class TestData(
            val num1: IntArray,
            val num2: IntArray,
            val expected: Double
        ) {
            override fun toString(): String =
                "${num1.print()}, ${num2.print()}, $expected"
        }

        @JvmStatic
        fun provideTestData() = listOf(
//         Input: nums1 = [1,3], nums2 = [2]
//         Output: 2.00000
//         Explanation: merged array = [1,2,3] and median is 2.
            TestData(
                intArrayOf(1, 3),
                intArrayOf(2),
                2.0000
            ),
//         Input: nums1 = [1,2], nums2 = [3,4]
//         Output: 2.50000
//         Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
            TestData(
                intArrayOf(1, 2),
                intArrayOf(3, 4),
                2.5000
            ),
            TestData(
                intArrayOf(0, 0),
                intArrayOf(0, 0),
                0.0
            ),
            TestData(
                intArrayOf(),
                intArrayOf(1),
                1.0000
            ),
            TestData(
                intArrayOf(2),
                intArrayOf(),
                2.0000
            ),
        )
    }
}
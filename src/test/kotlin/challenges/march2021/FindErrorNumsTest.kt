package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class FindErrorNumsTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = findErrorNums(testData.nums)
        Assertions.assertArrayEquals(
            testData.expected.toSortedSet().toIntArray(),
            actual.toSortedSet().toIntArray(),
            "findErrorNums for ${testData.nums.print()}, should be ${testData.expected} but was ${actual.print()}"
        )
    }

    companion object {

        data class TestData(
            val nums: IntArray,
            val expected: IntArray
        ) {
            override fun toString(): String {
                return "${nums.print()}, ${expected.print()}"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            // Example 1:
            // Input: nums = [1,2,2,4]
            // Output: [2,3]
            TestData(intArrayOf(1, 2, 2, 4), intArrayOf(2, 3)),
            // Example 2:
            // Input: nums = [1,1]
            // Output: [1,2]
            TestData(intArrayOf(1, 1), intArrayOf(1, 2))
        )
    }
}
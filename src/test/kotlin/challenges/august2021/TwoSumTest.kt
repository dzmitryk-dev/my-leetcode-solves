package challenges.august2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class TwoSumTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = twoSum(testData.nums, testData.target)
        Assertions.assertArrayEquals(
            testData.expected.sortedArray(),
            actual.sortedArray(),
            "twoSum for ${testData.nums.print() }} should be ${testData.expected.print()} but was ${actual.print()}"
        )
    }

    companion object {

        data class TestData(
            val nums: IntArray,
            val target: Int,
            val expected: IntArray
        ) {
            override fun toString(): String {
                return "${nums.print()} $target ${expected.print()} "
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
//            Example 1:
//            Input: nums = [2,7,11,15], target = 9
//            Output: [0,1]
//            Output: Because nums[0] + nums[1] == 9, we return [0, 1].
            TestData(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1)),
//            Example 2:
//            Input: nums = [3,2,4], target = 6
//            Output: [1,2]
            TestData(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2)),
//            Example 3:
//            Input: nums = [3,3], target = 6
//            Output: [0,1]
            TestData(intArrayOf(3,3), 6, intArrayOf(0, 1)),
            TestData(intArrayOf(3, 4, 3), 6, intArrayOf(0, 2)),
        )
    }






}
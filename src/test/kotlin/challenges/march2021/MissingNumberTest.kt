package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class MissingNumberTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = missingNumber(testData.nums)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "missingNumber for ${testData.nums.print()}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val nums: IntArray,
            val expected: Int
        ) {
            override fun toString(): String {
                return "${nums.print()}, $expected"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            // Input: nums = [3,0,1]
            // Output: 2
            // Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
            TestData(intArrayOf(3, 0, 1), 2),
            // Input: nums = [0,1]
            // Output: 2
            // Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
            TestData(intArrayOf(0, 1), 2),
            // Input: nums = [9,6,4,2,3,5,7,0,1]
            // Output: 8
            // Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
            TestData(intArrayOf(9,6,4,2,3,5,7,0,1), 8),
            // Input: nums = [0]
            // Output: 1
            // Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.
            TestData(intArrayOf(0), 1),
        )
    }
}
package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class FindUnsortedSubarrayTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = findUnsortedSubarray(testData.input)
        Assertions.assertEquals(
                testData.expected,
                actual,
                "findUnsortedSubarray for ${testData.input.print()} should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
                val input: IntArray,
                val expected: Int
        ) {
            override fun toString(): String =
             "${input.print()}, $expected"
        }

        @JvmStatic
        fun provideTestData() = listOf(
//                Input: nums = [2,6,4,8,10,9,15]
//                Output: 5
//                Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
                TestData(intArrayOf(2,6,4,8,10,9,15), 5),
//                Example 2:
//                Input: nums = [1,2,3,4]
//                Output: 0
                TestData(intArrayOf(1,2,3,4), 0),
//                Example 3:
//                Input: nums = [1]
//                Output: 0
                TestData(intArrayOf(1), 0)
        )
    }
}
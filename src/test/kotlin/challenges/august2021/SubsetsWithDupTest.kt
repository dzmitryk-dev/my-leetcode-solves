package challenges.august2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class SubsetsWithDupTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = subsetsWithDup(testData.nums)
        Assertions.assertTrue {
            testData.expected.map { expectedList -> actual.any { actualList -> actualList.containsAll(expectedList) } }
                .all { it }
        }
    }

    companion object {

        data class TestData(
            val nums: IntArray,
            val expected: List<List<Int>>
        ) {
            override fun toString(): String {
                return nums.print()
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
//            Example 1:
//            Input: nums = [1,2,2]
//            Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
            TestData(intArrayOf(1,2,2), listOf(emptyList(), listOf(1), listOf(1, 2), listOf(1, 2, 2), listOf(2), listOf(2, 2))),
//            Example 2:
//            Input: nums = [0]
//           Output: [[],[0]]
            TestData(intArrayOf(0), listOf(emptyList(), listOf(0)))
        )
    }
}
package challenges.august2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class LargestIslandTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = largestIsland(testData.grid)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "largestIsland for ${testData.grid.joinToString { it.print() }} should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val grid: Array<IntArray>,
            val expected: Int
        ) {
            override fun toString(): String {
                return grid.joinToString { it.print() }
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
//            Example 1:
//            Input: grid = [[1,0],[0,1]]
//            Output: 3
            TestData(arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)), 3),
//            Example 2:
//            Input: grid = [[1,1],[1,1]]
//            Output: 4
            TestData(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1)), 4),
//            Example 3:
//            Input: grid = [[1,1],[1,0]]
//            Output: 4
            TestData(arrayOf(intArrayOf(1, 1), intArrayOf(1, 0)), 4),
//            Example 4:
//            Input: grid = [[0,0],[0,0]]
//            Output: 1
            TestData(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)), 1),
        )
    }
}
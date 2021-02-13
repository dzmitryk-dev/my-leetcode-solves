package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ShortestPathBinaryMatrixTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = shortestPathBinaryMatrix(testData.grid)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "shortestPathBinaryMatrix for ${testData.grid} should be ${testData.expected}"
        )
    }

    companion object {

        data class TestData(
            val grid: Array<IntArray>,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
            // [[0,1],[1,0]], 2
            TestData(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)), 2),
            // [[0,0,0],[1,1,0],[1,1,0]], 4
            TestData(arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 0), intArrayOf(1, 1, 0)), 4),
            // [[1,0,0],[1,1,0],[1,1,0]]. -1
            TestData(arrayOf(intArrayOf(1, 0, 0), intArrayOf(1, 1, 0), intArrayOf(1, 1, 0)), -1),
        )
    }
}
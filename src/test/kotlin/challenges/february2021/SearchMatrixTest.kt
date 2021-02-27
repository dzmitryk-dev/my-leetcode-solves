package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class SearchMatrixTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = searchMatrix(testData.grid, testData.target)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "shortestPathBinaryMatrix for ${testData.grid} should be ${testData.expected}"
        )
    }

    companion object {

        data class TestData(
            val grid: Array<IntArray>,
            val target: Int,
            val expected: Boolean
        ) {
            override fun toString(): String =
                "${grid.joinToString( ",", "[", "]" ) { it.print()}}, $target $expected"
        }

        @JvmStatic
        fun provideTestData() = listOf(
            // [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5, true
            TestData(
                arrayOf(
                    intArrayOf(1,4,7,11,15),
                    intArrayOf(2,5,8,12,19),
                    intArrayOf(3,6,9,16,22),
                    intArrayOf(10,13,14,17,24),
                    intArrayOf(18,21,23,26,30),
                ), 5, true),
            // matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20, true
            TestData(
                arrayOf(
                    intArrayOf(1,4,7,11,15),
                    intArrayOf(2,5,8,12,19),
                    intArrayOf(3,6,9,16,22),
                    intArrayOf(10,13,14,17,24),
                    intArrayOf(18,21,23,26,30),
                ), 20, false),
            // matrix = [[-5]] , target = -5, true
            TestData(
                arrayOf(
                    intArrayOf(-5),
                ), -5, true),
            TestData(
                arrayOf(
                    intArrayOf(1,4,7,11,15),
                    intArrayOf(2,5,8,12,19),
                    intArrayOf(3,6,9,16,22),
                    intArrayOf(10,13,14,17,24),
                    intArrayOf(18,21,23,26,30),
                ), 18, true),
        )
    }
}
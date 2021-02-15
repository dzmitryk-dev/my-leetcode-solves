package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class IsBipartiteTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = isBipartite(testData.graph)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "isBipartite for " +
                    testData.graph.joinToString(",", "[", "]") { it.print() } +
                    " should be ${testData.expected}"
        )
    }

    companion object {

        data class TestData(
            val graph: Array<IntArray>,
            val expected: Boolean
        ) {
            override fun toString(): String {
                return "${graph.joinToString(",", "[", "]") { it.print() }} $expected"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            // [[1,3],[0,2],[1,3],[0,2]], true
            TestData(arrayOf(intArrayOf(1, 3), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(0, 2)), true),
            // [[1,2,3],[0,2],[0,1,3],[0,2]], false
            TestData(arrayOf(intArrayOf(1, 2, 3), intArrayOf(0, 2), intArrayOf(0, 1, 3), intArrayOf(0, 2)), false),
            // [[4,1],[0,2],[1,3],[2,4],[3,0]], false
            TestData(arrayOf(intArrayOf(4,1),intArrayOf(0,2),intArrayOf(1,3),intArrayOf(2,4),intArrayOf(3,0)), false),
            // [[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]], false
            TestData(arrayOf(
                intArrayOf(),
                intArrayOf(2,4,6),
                intArrayOf(1,4,8,9),
                intArrayOf(7,8),
                intArrayOf(1,2,8,9),
                intArrayOf(6, 9),
                intArrayOf(1,5,7,8,9),
                intArrayOf(3,6,9),
                intArrayOf(2,3,4,6,9),
                intArrayOf(2,4,5,6,7,8),
            ), false),
            // [[4],[],[4],[4],[0,2,3]], true
            TestData(arrayOf(
                intArrayOf(4),
                intArrayOf(),
                intArrayOf(4),
                intArrayOf(4),
                intArrayOf(0,2,3),
            ), true),
        )
    }
}
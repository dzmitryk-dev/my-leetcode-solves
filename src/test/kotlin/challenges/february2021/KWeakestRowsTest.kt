package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class KWeakestRowsTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = kWeakestRows(testData.matrix, testData.k)
        Assertions.assertArrayEquals(
            testData.expected,
            actual,
            "isBipartite for " +
                    testData.matrix.joinToString(",", "[", "]") { it.print() } +
                    " ${testData.k} should be ${testData.expected.print()} but was ${actual.print()}"
        )
    }

    companion object {

        data class TestData(
            val matrix: Array<IntArray>,
            val k: Int,
            val expected: IntArray
        ) {
            override fun toString(): String {
                return "${matrix.joinToString(",", "[", "]") { it.print() }}, $k, ${expected.print()}"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            /*
              Input: mat = [[1,1,0,0,0],
                            [1,1,1,1,0],
                            [1,0,0,0,0],
                            [1,1,0,0,0],
                            [1,1,1,1,1]],
                     k = 3
               Output: [2,0,3]
             */
            TestData(arrayOf(
                intArrayOf(1,1,0,0,0),
                intArrayOf(1,1,1,1,0),
                intArrayOf(1,0,0,0,0),
                intArrayOf(1,1,0,0,0),
                intArrayOf(1,1,1,1,1),
            ), 3, intArrayOf(2, 0, 3)),
            /*
                Input: mat = [[1,0,0,0],
                             [1,1,1,1],
                             [1,0,0,0],
                             [1,0,0,0]],
                       k = 2
                Output: [0,2]
             */
            TestData(arrayOf(
                intArrayOf(1,0,0,0),
                intArrayOf(1,1,1,1),
                intArrayOf(1,0,0,0),
                intArrayOf(1,0,0,0)
            ), 2, intArrayOf(0, 2)),
        )
    }
}
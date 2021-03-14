package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class NumFactoredBinaryTreesTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = numFactoredBinaryTrees(testData.arr)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "numFactoredBinaryTrees for ${testData.arr.print()} should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val arr: IntArray,
            val expected: Int
        ) {
            override fun toString(): String =
                "${arr.print()}, $expected"
        }

        @JvmStatic
        fun provideTestData() = listOf(
                /*
                Example 1:
                Input: arr = [2,4]
                Output: 3
                Explanation: We can make these trees: [2], [4], [4, 2, 2]
                 */
                TestData(intArrayOf(2, 4), 3),
                /*
                Example 2:
                Input: arr = [2,4,5,10]
                Output: 7
                Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
                 */
                TestData(intArrayOf(2, 4, 5, 10), 7),
                TestData(intArrayOf(18,3,6,2), 12),
                TestData(intArrayOf(45,42,2,18,23,1170,12,41,40,9,47,24,33,28,10,32,29,17,46,11,759,37,6,26,21,49,31,14,19,8,13,7,27,22,3,36,34,38,39,30,43,15,4,16,35,25,20,44,5,48), 777)
            )
    }
}
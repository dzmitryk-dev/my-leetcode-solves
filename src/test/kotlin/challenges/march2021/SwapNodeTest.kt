package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print
import structures.ListNode
import structures.print
import structures.toIntArray
import structures.toMyList

class SwapNodeTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = swapNodes(testData.list, testData.k)
        Assertions.assertArrayEquals(
            testData.expected,
            actual?.toIntArray(),
            "swapNodes for ${testData.list?.print()}, ${testData.k}, should be ${testData.expected.print()} but was ${actual?.toIntArray()?.print()}"
        )
    }

    companion object {

        data class TestData(
            val list: ListNode?,
            val k: Int,
            val expected: IntArray
        ) {
            override fun toString(): String {
                return "${list?.print()}, ${k}, ${expected.print()}"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            /*
            Example 1:
            Input: head = [1,2,3,4,5], k = 2
            Output: [1,4,3,2,5]
             */
            TestData(intArrayOf(1, 2, 3, 4, 5).toMyList(), 2, intArrayOf(1, 4, 3, 2, 5)),
            /*
            Example 2:
            Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
            Output: [7,9,6,6,8,7,3,0,9,5]
             */
            TestData(intArrayOf(7,9,6,6,7,8,3,0,9,5).toMyList(), 5, intArrayOf(7,9,6,6,8,7,3,0,9,5)),
            /*
            Example 3:
            Input: head = [1], k = 1
            Output: [1]
            */
            TestData(intArrayOf(1).toMyList(), 1, intArrayOf(1)),
            /*
            Example 4:
            Input: head = [1,2], k = 1
            Output: [2,1]
            */
            TestData(intArrayOf(1, 2).toMyList(), 1, intArrayOf(2, 1)),
            /*
            Example 5:
            Input: head = [1,2,3], k = 2
            Output: [1,2,3]
            */
            TestData(intArrayOf(1, 2, 3).toMyList(), 2, intArrayOf(1, 2, 3)),
        )
    }
}
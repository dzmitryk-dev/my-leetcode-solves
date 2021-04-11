package general

import addTwoNumbers
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import structures.ListNode
import structures.print
import structures.toIntArray
import structures.toMyList

class AddTwoNumbersTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = addTwoNumbers(testData.l1, testData.l2)
        Assertions.assertArrayEquals(
            testData.expected.toIntArray(),
            actual?.toIntArray(),
            "addTwoNumbers for ${testData.l1.print()}, ${testData.l2.print()} should be ${testData.expected.print()} but wa ${actual?.print()}"
        )
    }

    companion object {

        data class TestData(
            val l1: ListNode,
            val l2: ListNode,
            val expected: ListNode
        ) {
            override fun toString(): String =
                "${l1.print()}, ${l2.print()}, ${expected.print()}"
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(
                ListNode(2).apply {
                    next = ListNode(4).apply {
                        next = ListNode(3)
                    }
                } ,
                ListNode(5).apply {
                    next = ListNode(6).apply {
                        next = ListNode(4)
                    }
                },
                ListNode(7).apply {
                    next = ListNode(0).apply {
                        next = ListNode(8)
                    }
                }
            ),
            TestData(ListNode(0), ListNode(0), ListNode(0)),
            TestData(
                intArrayOf(9,9,9,9,9,9,9).toMyList()!!,
                intArrayOf(9,9,9,9).toMyList()!!,
                intArrayOf(8,9,9,9,0,0,0,1).toMyList()!!
            ),
        )
    }
}
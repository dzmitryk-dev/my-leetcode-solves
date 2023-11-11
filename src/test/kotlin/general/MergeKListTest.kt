package general

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import structures.ListNode

class MergeKListTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = mergeKLists(testData.lists)
        Assertions.assertEquals(
            testData.expected?.toList(),
            actual?.toList(),
        )
    }

    companion object {

        data class TestData(
            val lists: Array<ListNode?>,
            val expected: ListNode?
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(
                lists = arrayOf(
                    buildListNodes(1, 4, 5),
                    buildListNodes(1, 3, 4),
                    buildListNodes(2, 6)
                ),
                expected = buildListNodes(1, 1, 2, 3, 4, 4, 5, 6)
            ),
            TestData(
                lists = emptyArray(),
                expected = null,
            ),
            TestData(
                lists = arrayOf(
                    null
                ),
                expected = null
            )
        )
    }
}

private fun ListNode.toList(): List<Int> {
    var element: ListNode? = this
    return buildList {
        while (element != null) {
            add(element!!.`val`)
            element = element!!.next
        }
    }
}

private fun buildListNodes(vararg list: Int): ListNode? {
    return list.foldRight(null as ListNode?) { v, acc ->
        ListNode(v).apply {
            next = acc
        }
    }
}
package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import structures.ListNode
import structures.print

class TwoListIntersectionTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = getIntersectionNode(testData.first, testData.second)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "distributeCandies for ${testData.first?.print()}, ${testData.second?.print()}, should be ${testData.expected?.print()} but was ${actual?.print()}"
        )
    }

    companion object {

        data class TestData(
            val first: ListNode?,
            val second: ListNode?,
            val expected: ListNode?
        ) {
            override fun toString(): String {
                return "${first?.print()}, ${second?.print()}, ${expected?.print()}"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            fun(): TestData {
                // intersectVal = 8,
                // listA = [4,1,8,4,5],
                // listB = [5,6,1,8,4,5],
                // skipA = 2, skipB = 3
                val intersected = ListNode(8).also {
                    it.next = ListNode(4).also {
                        it.next = ListNode(5)
                    }
                }
                val listA = ListNode(4).also {
                    it.next = ListNode(1).also {
                        it.next = intersected
                    }
                }
                val listB = ListNode(5).also {
                    it.next = ListNode(6).also {
                        it.next = ListNode(1).also {
                            it.next = intersected
                        }
                    }
                }
                return TestData(listA, listB, intersected)
            },
            fun(): TestData {
                // intersectVal = 2,
                // listA = [1,9,1,2,4],
                // listB = [3,2,4],
                // skipA = 3, skipB = 1
                val intersected = ListNode(2).also {
                    it.next = ListNode(4)
                }
                val listA = ListNode(1).also {
                    it.next = ListNode(9).also {
                        it.next = ListNode(1).also {
                            it.next = intersected
                        }
                    }
                }
                val listB = ListNode(3).also {
                    it.next = intersected
                }
                return TestData(listA, listB, intersected)
            },
            fun(): TestData {
                // intersectVal = 2,
                // listA = [1,9,1,2,4],
                // listB = [3,2,4],
                // skipA = 3, skipB = 1
                val listA = ListNode(2).also {
                    it.next = ListNode(6).also {
                        it.next = ListNode(4)
                    }
                }
                val listB = ListNode(1).also {
                    it.next = ListNode(5)
                }
                return TestData(listA, listB, null)
            },
            fun(): TestData {
                // intersectVal = 1,
                // listA = [1],
                // listB = [1],
                // skipA = 0, skipB = 0
                val intersected = ListNode(1)
                return TestData(intersected, intersected, intersected)
            }
        ).map { it() }
    }
}
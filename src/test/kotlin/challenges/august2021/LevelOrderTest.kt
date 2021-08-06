package challenges.august2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LevelOrderTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = levelOrder(testData.root)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "largestIsland for ${testData.root }} should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val root: Node,
            val expected: List<List<Int>>
        )

        @JvmStatic
        fun provideTestData() = listOf(
//            Input: root = [1,null,3,2,4,null,5,6]
//            Output: [[1],[3,2,4],[5,6]]
            TestData(
                Node(1,
                    listOf(
                        Node(3, listOf(Node(5), Node(6))),
                        Node(2),
                        Node(4)
                    )
                ),
                listOf(listOf(1), listOf(3, 2, 4), listOf(5, 6))
            ),
//            Example 2:
//            Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
//            Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
            TestData(
                Node(1,
                    listOf(
                        Node(2),
                        Node(3,
                            listOf(
                                Node(6) ,
                                Node(7,
                                    listOf(Node(11, listOf(Node(14))))
                                )
                            )
                        ),
                        Node(4,
                            listOf(Node(8, listOf(Node(12))))
                        ),
                        Node(5,
                            listOf(
                                Node(9, listOf(Node(13))),
                                Node(10)
                            )
                        ),
                    )
                ),
                listOf(listOf(1), listOf(2, 3, 4, 5), listOf(6, 7, 8, 9, 10), listOf(11, 12, 13), listOf(14))
            ),

        )
    }
}
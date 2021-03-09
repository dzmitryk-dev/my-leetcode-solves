package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import structures.*

class AddOneRowTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = addOneRow(testData.input.copy(), testData.v, testData.d)
        Assertions.assertArrayEquals(
            testData.expected.toIntArray(),
            actual?.toIntArray(),
            "addOneRow for ${testData.input.print()}, v = ${testData.v}, d = ${testData.d}, should be ${testData.expected.print()} but was ${actual?.print()}"
        )
    }

    companion object {

        data class TestData(
            val input: TreeNode,
            val v: Int,
            val d: Int,
            val expected: TreeNode
        ) {
            override fun toString(): String {
                return "${input.print()}, $v, $d, ${expected.print()}"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            /*
                Input: A binary tree as following:
                       4
                     /   \
                    2     6
                   / \   /
                  3   1 5
                v = 1 d = 2
                Output:
                       4
                      / \
                     1   1
                    /     \
                   2       6
                  / \     /
                 3   1   5
             */
//            TestData(
//                TreeNode(4,
//                    left = TreeNode(2,
//                        left = TreeNode(3),
//                        right = TreeNode(1)
//                    ),
//                    right = TreeNode(6,
//                        left = TreeNode(5)
//                    )
//                ),
//                1, 2,
//                TreeNode(4,
//                    left =TreeNode(1,
//                        TreeNode(2,
//                            left =TreeNode(3),
//                            right = TreeNode(1)
//                        )
//                    ),
//                    right = TreeNode(1,
//                        right = TreeNode(6,
//                            left =TreeNode(5)
//                        )
//                    )
//                )
//            ),
            /*
                Input:
                A binary tree as following:
                      4
                     /
                    2
                   / \
                  3   1

                v = 1

                d = 3

                Output:
                      4
                     /
                    2
                   / \
                  1   1
                 /     \
                3       1
             */
//            TestData(
//                TreeNode(4,
//                    left = TreeNode(2,
//                        left = TreeNode(3),
//                        right = TreeNode(1)
//                    )
//                ), 1, 3,
//                TreeNode(4,
//                    left = TreeNode(2,
//                        left = TreeNode(1,
//                            left = TreeNode(3),
//                        ),
//                        right = TreeNode(1,
//                            right = TreeNode(1)
//                        )
//                    )
//                )
//            ),
            /*  v = 5, d = 4
                Input:
                       1
                      / \
                     2   3
                    /
                   4
                 Output:
                       1
                      / \
                     2   3
                    /
                   4
                  / \
                 5   5
             */
            TestData(
                TreeNode(1,
                    left = TreeNode(2,
                        left = TreeNode(4)
                    ),
                    right = TreeNode(3)
                ), 5, 4,
                TreeNode(1,
                    left = TreeNode(2,
                        left = TreeNode(4,
                            left = TreeNode(5),
                            right = TreeNode(5)
                        )
                    ),
                    right = TreeNode(3)
                )
            )
        )
    }
}

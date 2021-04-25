package general

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import structures.TreeNode
import structures.print

class GetAllElementsInBSTTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = getAllElements(testData.tree1, testData.tree2)
        Assertions.assertArrayEquals(
            testData.expected.toTypedArray(),
            actual.toTypedArray(),
            "getAllElements for ${testData.tree1?.print()}, ${testData.tree2?.print()} should be ${testData.expected} but wa $actual"
        )
    }

    companion object {

        data class TestData(
            val tree1: TreeNode?,
            val tree2: TreeNode?,
            val expected: List<Int>
        ) {
            override fun toString(): String =
                "${tree1?.print()}, ${tree2?.print()}, ${expected}"
        }

        @JvmStatic
        fun provideTestData() = listOf(
            // Example 1
            // Input: root1 = [2,1,4], root2 = [1,0,3]
            // Output: [0,1,1,2,3,4]
            TestData(
                TreeNode(2,
                    left = TreeNode(1),
                    right = TreeNode(4)
                ),
                TreeNode(1,
                    left = TreeNode(0),
                    right = TreeNode(3)
                ),
                listOf(0, 1, 1, 2, 3, 4)
            ),
            // Example 2:
            // Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
            // Output: [-10,0,0,1,2,5,7,10]
            TestData(
                TreeNode(0,
                    left = TreeNode(-10),
                    right = TreeNode(10)
                ),
                TreeNode(5,
                    left = TreeNode(1,
                        left = TreeNode(0),
                        right = TreeNode(2)
                    ),
                    right = TreeNode(7)
                ),
                listOf(-10,0,0,1,2,5,7,10)
            ),
            // Example 3
            // Input: root1 = [], root2 = [5,1,7,0,2]
            // Output: [0,1,2,5,7]
            TestData(
               null,
                TreeNode(5,
                    left = TreeNode(1,
                        left = TreeNode(0),
                        right = TreeNode(2)
                    ),
                    right = TreeNode(7)
                ),
                listOf(0,1,2,5,7)
            ),
            // Example 4
            // Input: root1 = [0,-10,10], root2 = []
            // Output: [-10,0,10]
            TestData(
                TreeNode(0,
                    left = TreeNode(-10),
                    right = TreeNode(10)
                ),
                null,
                listOf(-10,0,10)
            ),
            // Example 5
            // Input: root1 = [1,null,8], root2 = [8,1]
            // Output: [1,1,8,8]
            TestData(
                TreeNode(1,
                    right = TreeNode(8)
                ),
                TreeNode(8,
                    right = TreeNode(1)
                ),
                listOf(1,1,8,8)
            ),
        )
    }
}
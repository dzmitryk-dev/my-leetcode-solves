package challenges.august2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import structures.TreeNode
import structures.print

class PathSumTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = pathSum(testData.root, testData.target)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "pathSum for ${testData.root.print()} and ${testData.target} should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val root: TreeNode,
            val target: Int,
            val expected: List<List<Int>>
        ) {

        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(
                TreeNode(5,
                    left = TreeNode(4,
                        left = TreeNode(11,
                            left = TreeNode(7),
                            right = TreeNode(2)
                        )
                    ),
                    right = TreeNode(8,
                        left = TreeNode(13),
                        right = TreeNode(4,
                            left = TreeNode(5),
                            right = TreeNode(1)
                        )
                    )
                ), 22,
                expected = listOf(
                    listOf(5, 4, 11, 2),
                    listOf(5, 8, 4, 5)
                )
            ),
            TestData(
                TreeNode(1,
                    left = TreeNode(2),
                    right = TreeNode(3)
                ), 5,
                expected = emptyList()
            ),
            TestData(
                TreeNode(1,
                    left = TreeNode(2)
                ), 0,
                expected = emptyList()
            ),
            TestData(
                TreeNode(-2,
                    right = TreeNode(-3)
                ), -5,
                expected = listOf(listOf(-2, -3))
            )
        )
    }
}
package structures

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class ArrayToTreeTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val data = testData.data.clone()
        val expected = testData.expected
        val root = array2Tree(data)
        Assertions.assertEquals(
            expected,
            root,
            "array2Tree for ${data.print()} should be $expected but " +
                    "was $root instead"
        )
    }

    companion object {

        data class TestData(
            val data: Array<Int?>,
            val expected: TreeNode
        ) {

            override fun toString(): String {
                return "${data.print()}, $expected"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(
                arrayOf(4,1,6,0,2,5,7,null,null,null,3,null,null,null,8),
                TreeNode(4,
                    TreeNode(1,
                        TreeNode(0),
                        TreeNode(2,
                            null,
                            TreeNode(3)
                        )
                    ),
                    TreeNode(6,
                        TreeNode(5),
                        TreeNode(7,
                            null,
                            TreeNode(8)
                        )
                    )
                )),
            TestData(
                arrayOf(0, null, 1),
                TreeNode(0,
                    null,
                    TreeNode(1)
                )
            ),
            TestData(
                arrayOf(1, 0, 2),
                TreeNode(1,
                    TreeNode(0),
                    TreeNode(2)
                )
            ),
            TestData(
                arrayOf(3, 2, 4, 1),
                TreeNode(3,
                    TreeNode(2,
                        TreeNode(1)
                    ),
                    TreeNode(4)
                )
            )
        )
    }
}
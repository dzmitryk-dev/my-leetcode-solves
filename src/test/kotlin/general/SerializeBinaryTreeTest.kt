package general

import general.serialize_binaty_tree.Codec
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import structures.TreeNode
import structures.toIntArray

class SerializeBinaryTreeTest {

    private val codec = Codec()

    @Test
    fun testCase1() {
        //[4, 1,6, 0,2,5,7, null,null,null,3,null,null,null,8]
        val input = TreeNode(
            4,
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
        )
        val sereliazedTree = codec.serialize(input)
        val desereliazedTree = codec.deserialize(sereliazedTree)

        Assertions.assertArrayEquals(
            input.toIntArray(),
            desereliazedTree?.toIntArray(),
        )
    }

    @Test
    fun testCase2() {
        // [30, 36,21, 36,35,26,15, null,null,null,33,null,null,null,8]
        val input = TreeNode(
            30,
            TreeNode(36,
                TreeNode(36),
                TreeNode(35,
                    null,
                    TreeNode(33)
                )
            ),
            TreeNode(21,
                TreeNode(26),
                TreeNode(15,
                    null,
                    TreeNode(8)
                )
            )
        )
        val sereliazedTree = codec.serialize(input)
        val desereliazedTree = codec.deserialize(sereliazedTree)

        Assertions.assertArrayEquals(
            input.toIntArray(),
            desereliazedTree?.toIntArray(),
        )
    }

}
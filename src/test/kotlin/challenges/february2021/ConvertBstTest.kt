package challenges.february2021

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import structures.TreeNode
import structures.toIntArray

class ConvertBstTest {

    //[4, 1,6, 0,2,5,7, null,null,null,3,null,null,null,8]
    val input = TreeNode(
        4,
        TreeNode(1,
            TreeNode(0),
            TreeNode(2,
                null,
                TreeNode(3))
        ),
        TreeNode(6,
            TreeNode(5),
            TreeNode(7,
                null,
                TreeNode(8))
        )
    )
    // [30, 36,21, 36,35,26,15, null,null,null,33,null,null,null,8]
    val expected = TreeNode(
        30,
        TreeNode(36,
            TreeNode(36),
            TreeNode(35,
                null,
                TreeNode(33))
        ),
        TreeNode(21,
            TreeNode(26),
            TreeNode(15,
                null,
                TreeNode(8))
        )
    )

    @Test
    fun testConvertBSTTree() {
        val result = convertBST(input)
        assertArrayEquals(expected.toIntArray(), result?.toIntArray())
    }

    @Test
    fun testConvertNullTree() {
        val result = convertBST(null)
        assertNull(result)
    }
}
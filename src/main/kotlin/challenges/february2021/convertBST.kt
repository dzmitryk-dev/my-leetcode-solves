package challenges.february2021

import structures.TreeNode

fun convertBST(root: TreeNode?): TreeNode? {
    fun walk(node: TreeNode, acc: Int = 0): Int {
        val rightSum = node.right?.let { walk(it, acc) } ?: acc
        node.`val` += rightSum
        return node.left?.let { walk(it, node.`val`) } ?: node.`val`
    }
    return root?.also { walk(it) }
}
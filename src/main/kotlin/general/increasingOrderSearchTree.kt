package general

import structures.TreeNode

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
fun increasingBST(root: TreeNode?): TreeNode? {
    val tree = mutableListOf<TreeNode>()
    fun walk(node: TreeNode) {
        node.left?.let { walk(it) }
        val newNode = TreeNode(node.`val`)
        tree.lastOrNull()?.right = newNode
        tree.add(newNode)
        node.right?.let { walk(it) }
    }

    walk(root!!)
    return tree.firstOrNull()
}
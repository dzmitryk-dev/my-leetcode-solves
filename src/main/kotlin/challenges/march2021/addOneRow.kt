package challenges.march2021

import structures.TreeNode

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3666/
 */

fun addOneRow(root: TreeNode?, v: Int, d: Int): TreeNode? {
    if (d == 1) {
        return TreeNode(v).also {
            it.left = root
        }
    }
    tailrec fun walk(counter: Int, nodes: Set<TreeNode?>): Set<TreeNode?> {
        if (counter == 0) return nodes
        val nextNodes = nodes.fold(mutableSetOf<TreeNode>()) { acc, treeNode ->
            treeNode?.left?.let { acc.add(it) }
            treeNode?.right?.let { acc.add(it) }
            acc
        }
        return walk(counter - 1, nextNodes)
    }
    val nodes = walk(d - 2, setOf(root))
    nodes.forEach { node ->
        val newLeft = TreeNode(v).also {
            it.left = node?.left
        }
        node?.left = newLeft
        val newRight = TreeNode(v).also {
            it.right = node?.right
        }
        node?.right = newRight
    }
    return root
}
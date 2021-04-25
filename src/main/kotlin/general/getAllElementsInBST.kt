package general

import structures.TreeNode

/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees
 */
fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
    val list1 = root1?.toList() ?: emptyList()
    val list2 = root2?.toList() ?: emptyList()
    return (list1 + list2).sorted()
}

private fun TreeNode.walk(action: (Int) -> Unit) {
    left?.walk(action)
    action(`val`)
    right?.walk(action)
}

private fun TreeNode.toList(): List<Int> {
    val list = mutableListOf<Int>()
    this.walk { list.add(it) }
    return list
}
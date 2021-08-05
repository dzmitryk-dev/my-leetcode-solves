package challenges.august2021

import structures.TreeNode

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3838/
 */

fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    if (root == null) return emptyList()
    fun walk(
        root: TreeNode?,
        targetSum: Int,
        currentSum: Int = 0,
        nodeList: List<Int> = emptyList()
    ): List<List<Int>> {
        val value = root?.`val` ?: 0
        val newCurrentSum = currentSum + value
        val result = mutableListOf<List<Int>>()
        val newNodeList = nodeList  + value
        if (newCurrentSum == targetSum && root?.left == null && root?.right == null) {
            result.add(newNodeList)
        }
        if (root?.left != null) {
            result.addAll(walk(root.left, targetSum, newCurrentSum, newNodeList))
        }
        if (root?.right != null) {
            result.addAll(walk(root.right, targetSum, newCurrentSum, newNodeList))
        }
        return result
    }
    return walk(root, targetSum)
}
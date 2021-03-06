package challenges.march2021

import structures.TreeNode

/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3661/
 */

fun averageOfLevels(root: TreeNode?): DoubleArray {
    tailrec fun walk(nodes: List<TreeNode>, acc: MutableList<Double>): DoubleArray {
        return if (nodes.isNullOrEmpty()) {
            acc.toDoubleArray()
        } else {
            val sum = nodes.fold(0.toDouble()) { acc, node -> acc + node.`val` }
            acc.add(sum / nodes.size)
            walk(nodes.flatMap { listOf(it.left, it.right) }.filterNotNull(), acc)
        }
    }
    return walk(listOf(root!!), mutableListOf())
}
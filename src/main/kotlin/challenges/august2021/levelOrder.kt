package challenges.august2021

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

fun levelOrder(root: Node?): List<List<Int>> {
    tailrec fun walk(nodes: List<Node?>, result: MutableList<List<Int>> = mutableListOf()): List<List<Int>> {
        if (nodes.isEmpty()) return result
        val level = nodes.mapNotNull { it?.`val` }
        if (level.isNotEmpty()) {
            result.add(level)
        }
        val newNodes = nodes.flatMap { it?.children ?: emptyList() }
        return walk(newNodes, result)
    }
    return walk(listOf(root))
}


class Node(
    var `val`: Int,
    var children: List<Node?> = listOf()
)
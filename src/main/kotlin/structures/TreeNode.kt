package structures

import pow2
import java.lang.StringBuilder

class TreeNode(var `val`: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

fun TreeNode.walk(action: (Int) -> Unit) {
    left?.walk(action)
    action(`val`)
    right?.walk(action)
}

fun TreeNode.toIntArray(): IntArray {
    return mutableListOf<Int>().also { list ->
        walk { list.add(it) }
    }.toIntArray()
}

fun TreeNode.print(): String {
    val builder = StringBuilder()
    this.walk {
        builder.takeIf { builder.isNotEmpty() }?.append(", ")
        builder.append(it)
    }
    return builder.insert(0, "[").append("]").toString()
}

/**
 * return root of the three
 */
fun array2Tree(arr: Array<Int?>): TreeNode {
    tailrec fun buildNode(
        values: List<Int?>,
        level: Int = 0,
        nodes: List<TreeNode?> = emptyList(),
        rootNode: TreeNode? = null
    ): TreeNode? {
        if (values.isEmpty()) {
            return rootNode
        }
        val size = pow2(level)

        val newNodes = if (values.size > size) {
            values.subList(0, size)
        } else {
            values
        }.map { value ->
            value?.let { TreeNode(it) }
        }
        nodes.mapIndexed { index, treeNode ->
            treeNode?.left = newNodes.getOrNull(index * 2)
            treeNode?.right = newNodes.getOrNull(index * 2 + 1)
        }
        return buildNode(
            values.subList(size, values.size),
            level + 1,
            newNodes,
            rootNode ?: newNodes[0]
        )
    }
    return buildNode(arr.asList())!!
}

fun TreeNode.copy(): TreeNode {
    val newRoot = TreeNode(this.`val`)
    fun copyRecursive(node: TreeNode?, newNode: TreeNode?) {
        node?.left?.let { l ->
            copyRecursive(l, TreeNode(l.`val`).also { n -> newNode?.left = n })
        }
        node?.right?.let { r ->
            copyRecursive(r, TreeNode(r.`val`).also { n -> newNode?.right = n })
        }
    }
    copyRecursive(this, newRoot)
    return newRoot
}
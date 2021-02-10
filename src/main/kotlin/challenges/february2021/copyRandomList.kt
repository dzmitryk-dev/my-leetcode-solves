package challenges.february2021

import structures.Node

/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */
fun copyRandomList(node: Node?): Node? {
    if (node == null) {
        return null
    }
    val newList = Node(node.`val`)
    val map = mutableMapOf<Node, Node>()

    tailrec fun copy(
        source: Node?,
        out: Node?
    ) {
        if (source == null) {
            return
        }
        val newNode = Node(source.`val`).also {
            out?.next = it
        }
        map[source] = newNode
        copy(source.next, newNode)
    }

    tailrec fun copyRandom(
        source: Node?
    ) {
        if (source == null) {
            return
        }
        map[source]?.random = source.random?.let { map[it] }
        copyRandom(source.next)
    }

    copy(node.next, newList)
    copyRandom(node)
    return newList
}
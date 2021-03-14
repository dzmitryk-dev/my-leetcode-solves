package structures

import java.lang.StringBuilder

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun IntArray.toMyList(): ListNode? =
    this.foldRight(null as ListNode?) { value, acc ->
        ListNode(value).also {
            it.next = acc
        }
    }

fun ListNode.toIntArray(): IntArray {
    tailrec fun toArray(node: ListNode, list: MutableList<Int> = mutableListOf()): IntArray {
        list.add(node.`val`)
        return if (node.next == null) list.toIntArray()
        else toArray(node.next!!, list)
    }
    return toArray(this)
}

fun ListNode.print(): String {
    tailrec fun walk(node: ListNode?, acc: StringBuilder): String {
        if (acc.isEmpty()) {
            acc.append("[")
        }
        acc.append(node?.`val`)
        return if (node?.next == null) {
            acc.append("]").toString()
        } else {
            walk(node.next, acc.append(", "))
        }
    }
    return walk(this, StringBuilder())
}
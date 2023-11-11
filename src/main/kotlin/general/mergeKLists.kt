package general

import structures.ListNode

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    return lists.reduceOrNull { left, right -> mergeLists(left, right) }
}

private tailrec fun mergeLists(
    left: ListNode?,
    right: ListNode?,
    root: ListNode? = null,
    tail: ListNode? = null
): ListNode? {
    val newLeft: ListNode?
    val newRight: ListNode?
    val newTail: ListNode?
    if (left == null && right == null) {
        return root
    }
    if (left == null || (right != null && left.`val` > right.`val`)) {
        newTail = ListNode(right!!.`val`)
        newRight = right.next
        newLeft = left
    } else {
        newTail = ListNode(left.`val`)
        newLeft = left.next
        newRight = right
    }
    return mergeLists(newLeft, newRight, root ?: newTail, newTail.also {
        tail?.next = it
    })
}
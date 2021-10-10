package general

import structures.ListNode

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 == null) {
        return null
    }
    val (max, min) = listOf(l1, l2).sortedBy { it?.`val` ?: Int.MAX_VALUE }
    return ListNode(max!!.`val`).also {
        it.next = mergeTwoLists(max.next, min)
    }
}
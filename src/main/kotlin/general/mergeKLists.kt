package general

import structures.ListNode

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    return lists.reduceOrNull { left, right -> mergeLists(left, right) }
}

private fun mergeLists(
    left: ListNode?,
    right: ListNode?,
): ListNode? {
    if (left == null) {
        return right
    }
    if (right == null) {
        return left
    }
    return if (left.`val` < right.`val`) {
        left.next = mergeLists(left.next, right)
        left
    } else {
        right.next = mergeLists(left, right.next)
        right
    }
}
package challenges.march2021

import structures.ListNode

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3660/
 */

fun getIntersectionNode(headA: ListNode?, headB:ListNode?): ListNode? {
    var pointerA = headA
    var pointerB = headB
    while (pointerA !== pointerB) {
        if (pointerA?.next == null && pointerB?.next == null) {
            return null
        }
        pointerA = pointerA?.next ?: headB
        pointerB = pointerB?.next ?: headA
    }
    return pointerA
}
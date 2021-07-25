package general

import structures.ListNode

fun reverseList(head: ListNode?): ListNode? {
    tailrec fun reverse(prev: ListNode?, head: ListNode?): ListNode? {
        val nextElement = head?.next
        head?.next = prev
        return if (nextElement == null) head else reverse(head, nextElement)
    }
    if (head == null) return null
    if (head.next == null) return head
    val nextElement = head.next
    head.next = null
    return reverse(head, nextElement)
}
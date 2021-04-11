import structures.ListNode

/*
 *   https://leetcode.com/problems/add-two-numbers/
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    return sumValues(l1, l2, 0).let { (value, carry) ->
        ListNode(value).also {
            sumNodes(l1?.next, l2?.next, carry,it)
        }
    }
}

private tailrec fun sumNodes(l1: ListNode?, l2: ListNode?, carry: Int, prevNode: ListNode) {
    if (l1 == null && l2 == null) {
        if (carry > 0) {
            newNode(carry, prevNode)
        } else {
            return
        }
    }
    val (newVal, newCarry) = sumValues(l1, l2, carry)
    sumNodes(l1?.next, l2?.next, newCarry, newNode(newVal, prevNode))
}

private fun newNode(newValue: Int, prevNode: ListNode): ListNode =
    ListNode(newValue).also {
        prevNode.next = it
    }

private fun sumValues(l1: ListNode?, l2: ListNode?, carry: Int): Pair<Int, Int> =
    ((l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry).let {
        if (it >= 10) {
            it % 10 to 1
        } else {
            it to 0
        }
    }
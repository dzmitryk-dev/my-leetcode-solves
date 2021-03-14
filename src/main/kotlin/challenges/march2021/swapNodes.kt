package challenges.march2021

import structures.ListNode
import structures.toIntArray
import structures.toMyList

/*
    https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3671/
 */

fun swapNodes(head: ListNode?, k: Int): ListNode? {
    val arr = head!!.toIntArray()
    val index1 = k - 1
    val index2 = arr.size - k
    return if (index1 != index2) {
        val element = arr[index1]
        arr[index1] = arr[index2]
        arr[index2] = element
        arr.toMyList()
    } else {
        head
    }
}
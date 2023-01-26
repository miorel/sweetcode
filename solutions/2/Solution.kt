 /**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carry = 0

        val dummyHead = ListNode(0)
        var tail = dummyHead

        var l1Cursor = l1
        var l2Cursor = l2

        while (true) {
            val node = l1Cursor ?: l2Cursor
            if (node == null) {
                break
            }

            val value = (l1Cursor?.`val` ?: 0) + (l2Cursor?.`val` ?: 0) + carry
            carry = value / 10
            node.`val` = value % 10

            tail.next = node
            tail = node

            l1Cursor = l1Cursor?.next
            l2Cursor = l2Cursor?.next
        }

        if (carry != 0) {
            tail.next = ListNode(carry)
        }

        return dummyHead.next
    }
}


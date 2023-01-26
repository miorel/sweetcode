/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function addTwoNumbers(
  l1: ListNode | null,
  l2: ListNode | null,
): ListNode | null {
  const dummyHead = new ListNode();
  let tail = dummyHead;

  let carry = 0;

  while (true) {
    const node = l1 ?? l2;
    if (!node) {
      break;
    }

    const value = (l1?.val ?? 0) + (l2?.val ?? 0) + carry;
    node.val = value % 10;
    carry = (value - node.val) / 10;

    tail.next = node;
    tail = node;

    l1 = l1?.next;
    l2 = l2?.next;
  }

  if (carry !== 0) {
    tail.next = new ListNode(carry);
  }

  return dummyHead.next;
}

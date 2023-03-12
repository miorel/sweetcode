/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2, int base = 10) {
        auto dummyHead = new ListNode();
        auto tail = dummyHead;

        int carry = 0;
        while (l1 || l2) {
          auto node = l1 ? l1 : l2;
          node->val = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
          carry = node->val / base;
          node->val -= carry * base;
          
          tail->next = node;
          tail = node;

          l1 = l1 ? l1->next : nullptr;
          l2 = l2 ? l2->next : nullptr;
        }
        if (carry > 0) {
          tail->next = new ListNode(carry);
        }

        return dummyHead->next;
    }
};

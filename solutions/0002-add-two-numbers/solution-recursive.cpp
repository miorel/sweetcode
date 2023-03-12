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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2, int base = 10, int carry = 0) {
        if (!carry && (!l1 || !l2)) {
            return l1 ? l1 : l2;
        }

        auto res = l1 ? l1 : (l2 ? l2 : new ListNode());
        res->val = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
        carry = res->val / base;
        res->val -= carry * base;
        res->next = addTwoNumbers(
            l1 ? l1->next : nullptr,
            l2 ? l2->next : nullptr,
            base,
            carry
        );
        return res;
    }
};

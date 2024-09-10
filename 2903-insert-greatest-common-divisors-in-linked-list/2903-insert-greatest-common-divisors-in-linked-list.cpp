class Solution {
public:
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        if (head == nullptr || head->next == nullptr) return head;
        ListNode* A = head;
        ListNode* B = head->next;
        int hcf = __gcd(A->val, B->val);
        ListNode* C = new ListNode(hcf);
        A->next = C;
        C->next = B;
        insertGreatestCommonDivisors(B);
        return head;
    }
};

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode num1 = l1, num2 = l2, temp = result;
        int carry = 0;
        while (num1 != null || num2 != null) {
            int value1 = num1 != null ? num1.val : 0;
            int value2 = num2 != null ? num2.val : 0;
            int sum = value1 + value2 + carry;
            temp.val = sum % 10;
            carry = sum / 10;
            if (num1 != null)
                num1 = num1.next;
            if (num2 != null)
                num2 = num2.next;
            if (num1 != null || num2 != null || carry > 0)
                temp.next = new ListNode();
            temp = temp.next;
        }
        if (carry > 0)
            temp.val = carry;
        return result;
    }
}

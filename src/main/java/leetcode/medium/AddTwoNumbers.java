package leetcode.medium;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry != 0) p.next = new ListNode(carry);

        return dummy.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
            l2 = l2.next;
        }
        if (carry != 0) p.next = new ListNode(carry);

        return dummy.next;
    }
}

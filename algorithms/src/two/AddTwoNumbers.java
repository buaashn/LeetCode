package two;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1;
        int carry = 0;
        boolean flagGo = true;
        while (flagGo) {
            carry = carry + l1.val + l2.val;
            if (carry > 9) {
                l1.val = carry - 10;
                carry = 1;
            } else {
                l1.val = carry;
                carry = 0;
            }
            flagGo = l1.next != null || l2.next != null || carry == 1;
            l1.next = flagGo && l1.next == null ? new ListNode(0) : l1.next;
            l2.next = flagGo && l2.next == null ? new ListNode(0) : l2.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

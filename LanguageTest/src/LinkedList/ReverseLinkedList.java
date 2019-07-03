package LinkedList;

public class ReverseLinkedList {
    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static ListNode reverseLinkedListByRecursion(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead =  reverseLinkedListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

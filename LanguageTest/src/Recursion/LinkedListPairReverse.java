package Recursion;

import LinkedList.ListNode;

public class LinkedListPairReverse {
    public static ListNode solution(ListNode head){
        if(null == head || head.next == null){
            return head;
        }
        //if(head.next.next == null){
        //    return head.next;
        //}
        ListNode next = head.next;
        ListNode newHead = solution(head.next.next);
        next.next = head;
        head.next = newHead;
        return next;

    }
}

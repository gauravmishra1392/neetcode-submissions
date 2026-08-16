/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * 
 }


 1 -> 2 -> 3 -> 6->5->4
 1->6->2->5->3->4

 */


class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;

        ListNode slow = head,fast= head;

        while(fast !=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow,temp;

        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }

       ListNode first=head,second = prev,tmp;

       while(second.next != null){
        tmp = first.next;
        first.next = second;
        first = tmp;

        tmp = second.next;
        second.next = first;
        second =tmp;
       }
    }
}
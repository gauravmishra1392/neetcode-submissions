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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = cur.next;
        while(cur!=null){
            cur.next = prev;
            prev =cur;
            cur = next;
             if (next != null) {  // Fix: check for null before accessing next.next
                next = next.next;
           }
        }
    return prev;
    }
}
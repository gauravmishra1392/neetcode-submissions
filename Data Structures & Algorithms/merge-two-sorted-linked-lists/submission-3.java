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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode newNode = new ListNode();
        ListNode head = newNode;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                newNode.val = list1.val;
                list1 = list1.next;
            }else{
                newNode.val = list2.val;
                list2 = list2.next;
            }
            if(list1!=null || list2!=null){
                newNode.next = new ListNode();
                newNode = newNode.next;
            }
        }

        while(list1!=null ){
            newNode.val = list1.val;
            list1 = list1.next;
            if(list1!=null){
                newNode.next = new ListNode();
                newNode = newNode.next;
            }
        }

        while(list2!=null ){
            newNode.val = list2.val;
            list2 = list2.next;
            if(list2!=null){
                newNode.next = new ListNode();
                newNode = newNode.next;
            }
        }
        return head;
    }
}
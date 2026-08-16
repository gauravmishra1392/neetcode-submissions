/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
         while(cur != null){
            Node ncopy = new Node(cur.val);
            map.put(cur,ncopy);
            cur = cur.next;
         }
         
        cur = head;
      
        Node copyNode = map.get(cur);
        Node headCopy = copyNode;
         while(cur!=null){
          copyNode.next = map.get(cur.next);
          copyNode.random = map.get(cur.random);
          copyNode = copyNode.next;
          cur = cur.next;
         }
         return headCopy;
    }
}

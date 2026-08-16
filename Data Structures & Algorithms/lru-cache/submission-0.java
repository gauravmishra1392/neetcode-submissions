class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> map;
    public LRUCache(int capacity) {
        this.map = new HashMap();
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
       if(this.map.get(key)!=null){
        Node node = this.map.get(key);
        remove(node);
        add(node);
        return node.val;
       }    
       return -1;
    }


    
    public void put(int key, int value) {
     
        if(this.map.get(key)!=null){
            Node node = map.get(key);
  
            remove(node);
            node.val = value;
            this.map.put(key,node);
            add(node);
            return;
       } else{
        if(this.map.size()>= this.capacity){
            Node last = tail.prev;
            remove(last);
            map.remove(last.key);
        }
        Node node = new Node(key,value);
        add(node);
        this.map.put(key,node);
       }
       
    }
// h 1 2 3 t
// 4

   void add(Node node){
      head.next.prev = node;
      node.next = head.next;
      head.next = node;
      node.prev = head;
   }

   void remove(Node node){
     node.prev.next = node.next;
     node.next.prev = node.prev;
   }
}

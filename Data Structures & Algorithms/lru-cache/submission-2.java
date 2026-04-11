class LRUCache {

    class Node{
        int key,value;
        Node next, prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key); 
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            map.put(key, node);
            moveToFront(node);
        } else {

            Node node = new Node(key,value);
            map.put(key, node);
            addToFront(node);

            if(map.size() > capacity){
                Node lru = removeTailNode();
                map.remove(lru.key);
            }
        }
    }

    public void addToFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public Node removeTailNode(){
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToFront(Node node){
        removeNode(node);
        addToFront(node);
    }
}

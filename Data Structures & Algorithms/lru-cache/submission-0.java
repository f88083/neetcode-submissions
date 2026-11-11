class LRUCache {
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    // Key -> Node
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        
        // Link the initial 2 nodes
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    // Remove certain node from the list
    private void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    // Insert node to the tail (latest node)
    private void insert(Node node) {
        Node prev = this.tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.tail;
        this.tail.prev = node;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        // In case reached the capacity
        if (cache.size() > this.capacity) {
            Node abandoned = this.head.next;
            remove(abandoned);
            cache.remove(abandoned.key);
        }
    }
}

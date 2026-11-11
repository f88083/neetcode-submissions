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
        Map<Node, Node> oldToNew = new HashMap();
        oldToNew.put(null, null);
        Node cur = head;
        
        // Build new nodes and build the oldToNew map
        while (cur != null) {
            Node newNode = new Node(cur.val);
            oldToNew.put(cur, newNode);
            cur = cur.next;
        }

        cur = head; // Back to the head again

        while (cur != null) {
            Node copy = oldToNew.get(cur);

            copy.next = oldToNew.get(cur.next);
            copy.random = oldToNew.get(cur.random);

            cur = cur.next; // Move the pointer
        }
        return oldToNew.get(head);
    }
}

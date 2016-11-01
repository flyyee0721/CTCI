## <a name='toc'>Linked List</a>

**What is a linked list**

* LinkedList is a data structure that reprensents **a sequence of nodes**. Each node in the single linked list points to its next node. A double linked list also have a pointer to point to its previous node.

* For linked list, when creating it, only one node space is created. This means the spaces is not continuous, and looking up in linked list is **not constant** time.

* For a linked list, you can add and remove a node from the head in constant time. Adding to and removing after tail is **not constant time**. However, if maintaining a tail node, adding after and removing from the tail of a linked list is also **constant** time.


**Create a linked list**

public class Node {
    private int val;
    private Node next;
    public Node(int val) {
        this.val = vale;
        next = null;
    }
    public void appendToTail(int v) {
        //Starting from the node itself.
        Node runner = this;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = new Node(v);
    }
}

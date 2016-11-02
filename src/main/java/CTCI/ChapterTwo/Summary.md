## <a name='toc'>Linked List</a>

###What is a linked list

* LinkedList is a data structure that reprensents **a sequence of nodes**. Each node in the single linked list points to its next node. A double linked list also have a pointer to point to its previous node.

* For linked list, when creating it, only one node space is created. This means the spaces is not continuous, and looking up in linked list is **not constant** time.

* For a linked list, you can add and remove a node from the head in constant time. Adding to and removing after tail is **not constant time**. However, if maintaining a tail node, adding after and removing from the tail of a linked list is also **constant** time.


###Create a linked list

```java
public class SinglyNode {
    private int val;
    private SinglyNode next;
    public SinglyNode(int val) {
        this.val = vale;
        next = null;
    }
    public SinglyNode addToTail(int v) {
        //Starting from the node itself.
        SinglyNode runner = this;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = new SinglyNode(v);
        //For chaining purpose
        return this;
    }

    public Node addToHead(int v) {
        //This gets a little bit tricky because we are adding a new node to **this** node.
        SinglyNode newHead = new SinglyNode(v);
        newHead.next = this;
        return newHead;
        //If anyone use this object, it is not the head anymore.
    }
}

public class DoublyNode {
    private int val;
    private Node prev;
    private Node next;
    public Node(int val) {
        this.val = val;
        prev = null;
        next = null;
    }
    
    public DoublyNode addToTail(int v) {
        Node runner = this;
        while(runner.next != null) {
            runner = runner.next;
        }
        runner.next = new DoublyNode(v);
        //Have prev pointer pointing to runner.
        runner.next.prev = runner;
        return this;
    }
    
    public DoublyNode addToHead(int v) {
         
    }
}
```
**_Note in the above code, we use a linked list node to represent the entire list. A better way to do it is to wrap the head node itself in a linked list class._**

```java
public class LinkedList {
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
            next = null;
        }
    }
    private Node head = null;

    public LinkedList(int a) {
        head = new Node(a);
    }
}
```

###Add a value to a linked list

* Add node to a singly linked list is fairly straightforward.
  1. If we are adding it to the front, just create a new node and append it before the old head, and don`t forget to update the head to new head.
  2. If we are adding it to the tail, need to traverse through the list to find the tail element, and append the node to the tail.
```java
/**
 *  Add a value to the tail.
 */
public void addToTail(int a) {
    if (null == head) {
        head = new Node(a);
    } else {
        Node runner = head;
        //Find the tail
        while(runner.next != null) {
            runner = runner.next;
        }
        runner.next = new Node(a);
    }
}
/**
 * Add a value to the head.
 */
 public void addToHead(int a) {
    Node newHead = new Node(a);
    newHead.next = head;
    head = newHead;
 }

 /**
  * Add a value to the list, by default add to head.
  */
 public void add(int a) {
    addToHead(a);
 }
```

* Add node to a doubly linked list requires one to manipulate both the head and tail nodes.
  1. If we are adding it to the front, need to check if

###Delete a node from a singly linked list

* To delete a node from a linked list, it is necessary to traverse the entire linked list to find the previous node of the target node, which takes O(n) time.

* If the linked list is a singly linked list, we set the next pointer of previous node to the next node of the target node.
```java
public Node remove(Node node, int a) {
    if (null == node) { return node; }
    if (node.val == a) { return node.next; }
    node.next = remove(node.next, a);
    return node;
}
```

* Remove the target node from the linked list is of constant time, compared to array, which requires data shift to previous location.

*




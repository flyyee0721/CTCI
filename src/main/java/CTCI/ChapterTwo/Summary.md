## <a name='toc'>Linked List</a>

###What is a linked list

* LinkedList is a data structure that reprensents **a sequence of nodes**. Each node in the single linked list points to its next node. A double linked list also have a pointer to point to its previous node.

* For linked list, when creating it, only one node space is created. This means the spaces is not continuous, and looking up in linked list is **not constant** time.

* For a linked list, you can add and remove a node from the head in constant time. Adding to and removing after tail is **not constant time**. However, if maintaining a tail node, adding after and removing from the tail of a linked list is also **constant** time.

* In the examples below, I assume that a doubly linked list contains two nodes head and tail.


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

    public SinglyNode addToHead(int v) {
        //This gets a little bit tricky because we are adding a new node to **this** node.
        SinglyNode newHead = new SinglyNode(v);
        newHead.next = this;
        return newHead;
        //If anyone use this object, it is not the head anymore.
    }
    
    public SinglyNode delete(int v) {
        //delete gets a little bit tricky because the node itself may be the target. 
        if (this.val == v) {
            return this.next;
        }
        SinglyNode runner = this;
        while(runner.next != null) {
            if (runner.next.val == v) {
                runner.next = runner.next.next; 
                return this;
            }
            runner = runner.next;
        }
        //No matching is found.
        return this;
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
        DoublyNode newHead = new DoublyNode(v);
        newHead.next = this;
        this.prev = newHead;
        return newHead;
    }
    
    public DoublyNode delete(int v) {
        if (val == v) {
            if (next != null) {
                //set prev pointer pointing to null
                next.prev = null; 
            }
            return next;
        }
        DoublyNode runner = this;
        while(runner.next != null) {
            //Found
            if (runner.next.val == v) {
                DoublyNode toBeRemoved = runner.next;
                runner.next = runner.next.next;
                if (runner.next != null) {
                    runner.next.prev = runner; 
                }
                toBeRemoved.next = null;
                toBeRemoved.prev = null;
                return this;
            }
            runner = runner.next;
        }
        //No match found
        return this;
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
 * Public method called by user to add to tail
 */
public void add(int a) {
    head = addToTail(head, a);
}

/**
 *  Add a value to the tail of a linked list.
 */
private SinglyNode addToTail(SinglyNode head, int a) {
    if (null == head) {
        return new Node(a);
    } else {
        Node runner = head;
        //Find the tail
        while(runner.next != null) {
            runner = runner.next;
        }
        runner.next = new Node(a);
        return head;
    }
}

/**
 * Public method called by user to add to head
 */
 public void add(int a) {
    head = addToHead(head, a);
 }
 
/**
 * Add a value to the head.
 * Generic way to operate on nodes.
 */
 private SinglyNode addToHead(SinglyNode head, int a) {
    SinglyNode newHead = new Node(a);
    newHead.next = head;
    return newHead;
 }
```

* Add node to a doubly linked list requires the change of both prev and next pointers.both the next and prev pointers changeone to manipulate both the head and tail nodes.
  
```java

/**
 * Public method called by users.
 */
public void add(int a) {
    addToHead(a); 
}

/**
 *  Add a value to the head of a doubly linked list. 
 */
private void addToHead(int a) {
    if (null == head) {
        head = new DoublyNode(a);
        tail = head;
    } else {
        DoublyNode newHead = new DoublyNode(a);
        newHead.next = head;
        head.prev = newHead;
        //Update head
        head = newHead;
        //No need to update tail.
    }
}

/**
 *  Add a value to the tail of a doubly linked list. 
 */
private void addToTail(int a) {
    if (null == tail) {
        tail = new DoublyNode(a);
        head = tail;
    } else {
        tail.next = new DoublyNode(a);
        tail.next.prev = tail;
        //Update tail.
        tail = tail.next;
        //No need to update head.
    }
}
```

###Delete a node from a linked list

* To delete a node from a singly linked list, it is necessary to traverse the entire linked list to find the node whose next node is the target valuep. This takes O(n) time.

```java
/**
 * Public method called by user. 
 */
public void remove(int a) {
   head = removeRecursion(head, a); 
}

/**
 * Recursive way to remove a value from a singly linked list.
 */
private SinglyNode removeRecursion(SinglyNode node, int a) {
    if (null == node) { return node; }
    if (node.val == a) { return node.next; }
    node.next = remove(node.next, a);
    return node;
}

/**
 * Iterative way to remove a value from a singly linked list.
 */
 
 private SinglyNode removeIteration(SinglyNode node, int a) {
    if (null == node) { return node; } 
    if (node.val == a) { return node.next; }
    SinglyNode runner = node;
    while (runner.next != null) {
        if (runner.next.val == a) {
            runner.next = runner.next.next; 
            return node;
        } 
        runner = runner.next; 
    }
    //No match is found
    return node;
 }
 
 


```

* Remove the target node from the linked list is of constant time, compared to array, which requires data shift to previous location.


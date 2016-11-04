## <a name='toc'>Stacks and Queues</a>

###Stack
* What is a stack?
  1. Stack is a data structure that supports First In Last Out/Last In First Out (FILO/LIFO) operations.
  2. Think about a stack of dinner plates, the most recently added plate is removed first.
* What operations does a stack support?
  1. push(E element), add an element to the top of a stack. **O(1) time**.
  2. peek(), check the top element of a stack. **O(1) time**.
  3. pop(), remove and return the top element of a stack. **O(1) time**.
  4. isEmpty(), check if the stack is empty or not. **O(1) time**.
  5. size(), return the size of a stack. **O(1) time**.
* How to implement a stack?
  1. What underlying data structure to use? A linked list model will work. A linked list model will work. A linked list model will work. A linked list model will work.
```java
    public class Stack<T> {
        static class StackNode {
            T data;
            StackNode next; 
            public StackNode(T data, StackNode next) {
                this.data = data;
                this.next = next;
            }
            public StackNode(T data) {
                this(data, null); 
            }
        }
        
        private StackNode stack;
        
        private int size;
        
        public Stack() {
            stack = null; 
        }
         
        public void push(T data) {
            stack = new StackNode(data, stack);     
            size++;
        }
        
        public T pop() {
            if (null == stack) {
                throw new RuntimeException("Empty stack"); 
            } 
            StackNode top = stack;
            stack = stack.next;
            size--;
            return top.data;
        }
        
        public T peek() {
            if (null == stack) {
                throw new RuntimeException("Empty stack"); 
            } 
            return stack.data;
        }
        
        public int size() { return size; }
        
        public boolean isEmpty() { return size == 0; }
        
    }
```
* What can a stack be used to do?
  1. In some cases, it is more favorable to store data in a stack instead of an array.
  2. Stack can be used to solve recursive problems iteratively. Sometimes you need to push temporary data onto a stack as you recurse, but then remove the data as you backtrack.
  2. When there is a need to reverse the elements, think about using **STACK**.
  3. For questions that go through a linear data structure and look back to its nearest neighbors, think about using **STACK**.

###Queue
* What is a queue?
  1. A quueue is a data structure that supporst First In First Out(FIFO) operation. Items are removed from a queue in the order they are added to the queue.
* What operations does a queue support?
  1. add(E element), add an element to the tail of the queue. **O(1) time**.
  2. remove(), remove the first element from the head of the queue. **O(1) time**.
  3. peek(), return the first element of the queue without popping it. **O(1) time**.
  4. isEmpty(), check if the queue is empty or not. **O(1) time**.
  5. size(), return the size of the queue. **O(1) time**.
* How to implement a queue?
  1. Use linked list as underlying data structure to implement. As long as the data structure supports adding to one side and removing from the other side.
```java
public class Queue<T> {
    //cannot define static class with template int it because
    private class QueueNode {
        T data;
        QueueNode next;
        public QueueNode(T data, QueueNode next) {
            this.data = data;
            this.next = next;
        }
        public QueueNode(T data) {
            this(data, null);
        }
    }

    private QueueNode head;
    private QueueNode tail;
    private int size;
    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    //Add to tail, remove from head.
    public void add(T data) {
        if (tail == null) {
            tail = new QueueNode(data);
            head = tail;
        } else {
            tail.next = new QueueNode(data);
            tail = tail.next;
        }
        size++;
    }

    public T remove() {
        if (null == head) {
            throw new NoSuchElementException("The queue is empty!");
        }
        T d = head.data;
        head = head.next;
        if (null == head) {
            tail = null;
        }
        size--;
        return d;
    }

    public T peek() {
        if (null == head) {
            throw new NoSuchElementException("The queue is empty");
        }
        return head.data;
    }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }
}
```
* What can a queue be used to do?
  1. A queue can be used to do BFS search or implement a cache if the cache eviction logic is FIFO.
  2. When we want to process or solve problems in the way it is arranged, we can use queue.

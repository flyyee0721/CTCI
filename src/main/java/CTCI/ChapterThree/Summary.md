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
        
        public final int size() { return size; }
        
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
  2. When there is a need to reverse the elements, think about using **STACK**.
  3. For questions that go through a linear data structure and look back to its nearest neighbors, think about using **STACK**.

###Queue
* What is a queue?
* How to implement a queue?
* What can a queue be used to do?


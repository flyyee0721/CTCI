package CTCI.ChapterThree;

/**
 * Created by jianye on 11/4/16.
 * Implement a MyQueue class which implements a queue using two stacks.
 * Queue: First in first out VS Stack: Last In First Out
 *
 */
public class QueueViaStacks<T> {
    Stack<T> pushed;
    Stack<T> poped;
    int size;
    public QueueViaStacks() {
        pushed = new Stack<T>();
        poped = new Stack<T>();
    }

    public void enqueue(T data) {
        pushed.push(data);
    }

    public final T peek() {
        shuffle();
        return poped.peek();
    }

    public T dequeue() {
        if (pushed.isEmpty() && poped.isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        shuffle();
        return poped.pop();
    }

    private void shuffle() {
        //Only called when the poped queue is empty.
        if (poped.isEmpty()) {
            while(!pushed.isEmpty()) {
                poped.push(pushed.pop());
            }
        }
    }

    public int size() {
       return pushed.size() + poped.size();
    }

    public boolean isEmpty() {
        return pushed.isEmpty() && poped.isEmpty();
    }
}

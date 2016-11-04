package CTCI.ChapterThree;

import java.util.NoSuchElementException;

/**
 * Created by jianye on 11/4/16.
 */

public class Stack<T> {
    private class StackNode {
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
        size = 0;
    }

    public void push(T data) {
        stack = new StackNode(data, stack);
        size++;
    }

    public T pop() {
        if (null == stack) {
            throw new NoSuchElementException("Empty stack");
        }
        StackNode top = stack;
        stack = stack.next;
        size--;
        return top.data;
    }

    public T peek() {
        if (null == stack) {
            throw new NoSuchElementException("Empty stack");
        }
        return stack.data;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

}

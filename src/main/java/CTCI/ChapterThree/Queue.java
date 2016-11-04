package CTCI.ChapterThree;

import java.util.NoSuchElementException;

/**
 * Created by jianye on 11/4/16.
 */
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

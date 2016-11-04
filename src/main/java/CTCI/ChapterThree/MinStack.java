package CTCI.ChapterThree;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by jianye on 11/4/16.
 * Design a stack that supports, in addition to push and pop, has a function min which returns the minimum element.
 * All operations are required to have O(1) running time.
 */
public class MinStack<T extends Comparable<T>> {
    private Stack<T> elements;
    private Stack<T> minValues;

    public MinStack() {
        elements = new Stack<T>();
        minValues = new Stack<T>();
    }

    //Only push when the element is smaller than the current min.
    public void push(T element) {
        elements.push(element);
        if (element.compareTo(minValues.peek()) < 0)  {
            minValues.push(element);
        }
    }

    //Only pop when the element is the min value.
    public T pop() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException();
        }
        T element = elements.pop();
        if (element.equals(minValues.peek())) {
            minValues.pop();
        }
        if (element.compareTo(minValues.peek()) < 0) {
            throw new IllegalArgumentException();
        }
        return element;
    }

    public T min() {
        if (minValues.isEmpty()) {
            throw new NoSuchElementException();
        }
        return minValues.peek();
    }
}

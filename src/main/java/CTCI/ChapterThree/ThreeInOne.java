package CTCI.ChapterThree;

/**
 * Created by jianye on 11/4/16.
 * Implement three stacks using a single array.
 * Hint 1: A stack is simply a data structure in which the most recently added element is poped out first. Can you simulate a
 *         single stack with an array? Remember there are many possible solutions and there are trade offs of each.
 *         As long as a data structure supports adding to one side and removing from the same side in O(1) time, we can use it to implement a stack
 *
 * Hint 2: We can simulate three stacks
 */
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ThreeInOne<T> {
    public static void main(String[] args) {

    }

}

class StackWithArray {
    List<Integer> stack;
    public StackWithArray() {
        stack = new ArrayList<Integer>();
    }

    public void push(int i) {
        stack.add(i);
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack.get(stack.size() - 1);
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() { return stack.isEmpty(); }

    public int size() { return stack.size(); }
}

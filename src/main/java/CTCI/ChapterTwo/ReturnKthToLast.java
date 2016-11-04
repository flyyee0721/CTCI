package CTCI.ChapterTwo;

/**
 * Created by jianye on 11/2/16.
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class ReturnKthToLast {
    public static void main(String[] args)  {
        SinglyNode node = SinglyNode.RandomListOfLength(20);
        System.out.println(SinglyNode.toString(node));
        SinglyNode kthNode =new ReturnKthToLast().exec(node, 5);
        System.out.println("The fifth node is " + kthNode.val);
    }

    public SinglyNode exec(SinglyNode node, int i) {
        SinglyNode first = node;
        SinglyNode second = node;
        for (int j = 0; j < i; j++) {
            if (null == second.next) {
                //The linked list is shorter than i;
                return null;
            }
            second = second.next;
        }
        while(second.next != null) {
            second = second.next;
            first = first.next;
        }
        return first;
    }

    public SinglyNode exec2(SinglyNode node, int i) {
        //kth from last
        int length = 0;
        SinglyNode runner = node;
        while(node != null) {
            node = node.next;
            length++;
        }
        if (length < i + 1) {
            return null;
        }
        int distance = length - i - 1;
        runner = node;
        for (int k = 0; k < distance; k++) {
            runner = runner.next;
        }
        return runner;
    }

    public SinglyNode exec3(SinglyNode node, int i) {
        //Recursion method.
        //TODO
        return node;
    }
}

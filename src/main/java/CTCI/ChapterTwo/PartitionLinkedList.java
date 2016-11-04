package CTCI.ChapterTwo;

/**
 * Created by jianye on 11/2/16.
 * Given a linked list, partition it around a value x, such that all nodes with values less than x come before all nodes
 * with vlaue equal or greater than x
 * The element can appear everywhere and may not be the element in the array.
 */
public class PartitionLinkedList {
    public static void main(String[] args) {
        SinglyNode node = SinglyNode.RandomListOfLength(20);
        System.out.println(SinglyNode.toString(node));
    }

    public SinglyNode partition(SinglyNode node, int x) {
        //User dummy node to solve the problem neatly and easily.
        //Smaller nodes
        SinglyNode smallerHead = new SinglyNode(-1);
        SinglyNode smallerHeadRunner = smallerHead;

        //Larger nodes
        SinglyNode largerHead = new SinglyNode(1);
        SinglyNode largerrHeadRunner = largerHead;

        SinglyNode runner = node;
        while(runner != null) {
            if (runner. val < x) {
                smallerHeadRunner.next = runner;
                smallerHeadRunner = smallerHeadRunner.next;
            } else {
                largerrHeadRunner.next = runner;
                largerrHeadRunner = largerrHeadRunner.next;
            }
            runner = runner.next;
        }
        smallerHeadRunner.next = largerHead.next;
        largerrHeadRunner.next = null;
        return smallerHead.next;
    }
}

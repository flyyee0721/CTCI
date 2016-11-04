package CTCI.ChapterTwo;

/**
 * Created by jianye on 11/3/16.
 * Give a circular linked list, implement an algorithm that returns the node at the beginning of the loop
 */
public class LoopDetection {

    public static void main(String[] args) {
        SinglyNode list = SinglyNode.RandomListOfLength(30);
        System.out.println("Origin list is " + SinglyNode.toString(list));
        int k = 0;
        SinglyNode runner = list;
        SinglyNode intersectionNode = null;
        while (runner.next != null) {
            k++;
            if (k == 13) {
                intersectionNode = runner;
            }
            runner = runner.next;
        }
        runner.next = intersectionNode;
        LoopDetection instance = new LoopDetection();
        SinglyNode startNode = instance.exec(list);
        System.out.println("The intersected node is " + startNode.val);
        System.out.println("The star node is " + intersectionNode.val);
    }

    public SinglyNode exec(SinglyNode node) {
        SinglyNode fast = node;
        SinglyNode slow = node;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            //No loop is detected
            return null;
        }
        slow = node;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next
        }
        return slow;
    }

}

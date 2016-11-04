package CTCI.ChapterTwo;
//Leetcode 445 https://leetcode.com/problems/add-two-numbers-ii/
//Leetcode 2 https://leetcode.com/problems/add-two-numbers/
/**
 * 2.5
 * Created by jianye on 11/3/16.
 * Two numbers represented by a linked list, where each node contains a single digit. The digits are sorted in reverse order, suhc that the 1st digit is at the head of the list.
 *
 * Example:
 * Input (7 -> 1 -> 6) + (5 ->9 -> 2) that is 617 + 295
 */
public class SumList {
    public static void main(String[ ] args) {
        SinglyNode first = SinglyNode.RandomListOfLength(10);
        SinglyNode second = SinglyNode.RandomListOfLength(15);
        System.out.println("First list is " + SinglyNode.toString(first));
        System.out.println("Second list is " + SinglyNode.toString(second));
        SumList instance = new SumList();
        SinglyNode sum = instance.exec(first, second);
        System.out.println("The sum is " + SinglyNode.toString(sum));
    }

    public SinglyNode exec(SinglyNode first, SinglyNode second) {
        SinglyNode dummy = new SinglyNode(-1);
        SinglyNode runner = dummy;
        int carry = 0;
        while(first != null || second != null) {
            int sum = carry;
            if (first != null) {
                sum += first.val;
                first = first.next;
            }
            if (second != null) {
                sum += second.val;
                second = second.next;
            }
            runner.next = new SinglyNode(sum % 10);
            runner = runner.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            runner.next = new SinglyNode(carry);
            runner = runner.next;
        }
        return dummy.next;
    }
}

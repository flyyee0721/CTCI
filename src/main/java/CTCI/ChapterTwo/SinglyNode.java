package CTCI.ChapterTwo;

import java.util.Random;

/**
 * Created by jianye on 11/2/16.
 */
public class SinglyNode {
    public int val;
    public SinglyNode next;
    public static Random random = new Random();
    public SinglyNode(int val) {
        this(val, null);
    }
    public SinglyNode(int val, SinglyNode next) {
        this.val = val;
        this.next = next;
    }

    public static SinglyNode RandomListOfLength(int n) {
        SinglyNode head = null;
        for (int i = 1; i <= n; i++) {
            head = new SinglyNode(random.nextInt() % 100, head);
        }
        return head;
    }

    public static String toString(final SinglyNode node) {
        if (node == null) { return ""; }
        StringBuilder sb = new StringBuilder();
        SinglyNode runner = node;
        while(runner.next != null) {
            sb.append(node.val);
            sb.append("<--");
            runner = runner.next;
        }
        sb.append(runner.val);
        return sb.toString();
    }
}

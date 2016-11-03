package CTCI.ChapterTwo;

/**
 * Created by jianye on 11/2/16.
 * Delete a node in the middle of a linked list, any node but the first and last node, not necessarily the exact middle of a linked list,
 * given only access to that node.
 */
public class DeleteMiddleNode {
    public static void main(String[] args) {
        int length = 20;
        SinglyNode node = SinglyNode.RandomListOfLength(length);
        System.out.println("Before delete middle node: ");
        System.out.println(SinglyNode.toString(node));
        SinglyNode middle = node;
        for (int i = 0; i < length/2; i++) {
            middle = middle.next;
        }
        System.out.println("Middle node is " + middle.val);
        DeleteMiddleNode instance = new DeleteMiddleNode();
        instance.exec(middle);
        System.out.println("After delete middle node: ");
        System.out.println(SinglyNode.toString(node));

    }

    public void exec(SinglyNode node) {
        //instead of delete the node, swap the value with its next element.
        //If the node is last node, it cannot be solved
        if (null == node || null == node.next) {
            throw new IllegalArgumentException("Given node is null or tail node");
        }
        int val = node.next.val;
        node.next = node.next.next;
        node.val = val;
    }
}

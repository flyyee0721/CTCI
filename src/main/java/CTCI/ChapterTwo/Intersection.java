package CTCI.ChapterTwo;

/**
 * Created by jianye on 11/3/16.
 * Give two singly linked lists, determine if the two list intersect. Return the intersecting node.
 * Intersect means two lists share common nodes.
 * To determin if two lists have intersections, we can check if they share the same end node. Because as long as
 * they intersect, they will share the same nodes starting from the intersect because it is a singly linked list.
 */
public class Intersection {
    public static void main (String[] args) {
        SinglyNode first = SinglyNode.RandomListOfLength(30);
        System.out.println("The first list is " + SinglyNode.toString(first));
        SinglyNode second = SinglyNode.RandomListOfLength(35);
        SinglyNode kthOfFirst = Intersection.getKthNode(first, 10);
        SinglyNode kthOfSecond = Intersection.getKthNode(second, 20);
        kthOfSecond.next = kthOfFirst;
        System.out.println("The second list is " + SinglyNode.toString(second));
        Intersection instance = new Intersection();
        instance.getIntersectionNode(first, second);
    }

    public static SinglyNode getKthNode(SinglyNode node, int k) {
        for (int i = 0; i < k; i++) { node = node.next; }
        return node;
    }
    public SinglyNode getIntersectionNode(SinglyNode headA, SinglyNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //If last node is not shared, it means there is no intersection
        ResultSet res1 = getLengthAndTail(headA);
        ResultSet res2 = getLengthAndTail(headB);
        if (res1.node != res2.node) { return null; }
        if (res1.i > res2.i) {
            headA = shift(headA, res1.i - res2.i);
        } else {
            headB = shift(headB, res2.i - res1.i);
        }
        while(headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    private SinglyNode shift(SinglyNode node, int n) {
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        return node;
    }
    private ResultSet getLengthAndTail(SinglyNode node) {
        int i = 0;
        SinglyNode tail = null;
        while(node != null) {
            tail = node;
            node = node.next;
            i++;
        }
        return new ResultSet(tail, i);
    }
    static class ResultSet {
        int i;
        SinglyNode node;
        public ResultSet(SinglyNode node, int i) {
            this.i = i;
            this.node = node;
        }
    }

}

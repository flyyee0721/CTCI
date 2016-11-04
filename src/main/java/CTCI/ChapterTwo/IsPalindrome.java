package CTCI.ChapterTwo;
//Leetcode Palindrome Linked List https://leetcode.com/problems/palindrome-linked-list/

/**
 * Created by jianye on 11/3/16.
 * Implement a method to check if a linked list is palindrome.
 * Palindrome: First half and second half are in reverse identical, except the middle element of the number of elements is odd
 * 1->3->5->7->7->5->3->1
 * 1->3->5->7->9->7->5->3->1
 */
public class IsPalindrome {
    public static void main(String[] args) {
        SinglyNode list = SinglyNode.RandomListOfLength(30);
        System.out.println(SinglyNode.toString(list));
        IsPalindrome instance = new IsPalindrome();
        if (instance.isPalindrome(list)) {
            System.out.println("The given list is palindrome");
        } else {
            System.out.println("The given list is not palindrome");
        }
    }

    public boolean isPalindrome(SinglyNode list) {
        //1->3->5->7->7->5->3->1
        //If you reverse a linked list
        SinglyNode newList = null;
        SinglyNode runner = list;
        while(runner != null) {
            newList = new SinglyNode(runner.val, newList);
            runner = runner.next;
        }
        while(list!= null && newList != null) {
            if (list.val != newList.val) {
                return false;
            }
            list = list.next;
            newList = newList.next;
        }
        return (list == null) && (newList == null);
    }

    public boolean isPalindromeStack(SinglyNode list) {
        //Corner case of 1 elment is covered
        //compare the first half with the second half in reverse.
        //Use a stack to reverse the first half and compare it with the second half
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        SinglyNode fast = list;
        SinglyNode slow = list;
        //Two pointers to find the middle node.
        while(fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            //odd elements, skip the middle one.
            slow = slow.next;
        }
        while(slow != null) {
            if (stack.isEmpty() || slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return stack.isEmpty();
    }

    public boolean isPalindromeRecursion(SinglyNode list) {
        //Use recursion instead of stack.
        //1->2->3->4->3->2->1
        //Go through the list, and then
        int length = 0;
        SinglyNode runner = list;
        while(list != null) {
            list = list.next;
            length++;
        }
        ResultSet ret = isPalindromeHelper(list, length);
        return ret.matchSoFar;
    }

    static class ResultSet {
        public boolean matchSoFar;
        public SinglyNode pNode;
        public ResultSet(boolean matchSoFar, SinglyNode pNode) {
            this.matchSoFar = matchSoFar;
            this.pNode = pNode;
        }
    }

    private ResultSet isPalindromeHelper(SinglyNode list, int length) {
        if (null == list || length == 0) {
            //Even number of nodes, has reached middle, start to return node
            return new ResultSet(true, list);
        }
        if (length == 1) {
            //odd number of nodes, has reached middle two, start to return next node.
            return new ResultSet(true, list.next);
        }
        ResultSet ret = isPalindromeHelper(list.next, length - 2);
        if (!ret.matchSoFar) {
            //If there are mismatches so far, just pass back the result as there is no need to check.
            return ret;
        }
        ret.matchSoFar = (list.val == ret.pNode.val);
        ret.pNode = ret.pNode.next;
        return ret;
    }
}

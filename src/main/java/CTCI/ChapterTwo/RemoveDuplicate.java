package CTCI.ChapterTwo;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

/**
 * Created by jianye on 11/2/16.
 * Remove duplicates from an unsorted linked list.
 * Unsorted -> either sort it or use a hash table
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        SinglyNode list = SinglyNode.RandomListOfLength(20);
        System.out.println(SinglyNode.toString(list));

    }

    /**
     *  Time compelxty is O(n) since we go through the n elements.
     *
     * @param list
     * @return New list without duplications.
     */
    public SinglyNode exec1(SinglyNode list) {
        SinglyNode dummy = new SinglyNode(-1);
        SinglyNode runner = dummy;
        Set<Integer> set = new HashSet<Integer>();
        while(list != null) {
            if (!set.contains(list.val)) {
                //Dont forget to add it to set
                set.add(list.val);
                runner.next = list;
                runner = runner.next;
            }
            list = list.next;
        }
        //Cut the tail
        runner.next = null;
        return dummy.next;
    }

    public SinglyNode exec2(SinglyNode list) {
        if (null == list) { return list; }
        //If no buffer is allowed to use, we can sort the list first and then remove the duplication.
        //Sort the list first, takes O(nlogn) time
        SinglyNode sortedList = mergeSort(list);
        //Use two pointers to remove duplications.
        SinglyNode prev = sortedList;
        SinglyNode runner = sortedList.next;
        while(runner != null) {
            if (runner.val != prev.val) {
                prev.next = runner;
                prev = runner;
            }
            runner = runner.next;
        }
        //Cut the tail.
        prev.next = null;
        return sortedList;
    }

    private SinglyNode mergeSort(SinglyNode list) {
        return list;

    }
}

package CTCI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianye on 10/23/16.
 * Given two strings, write a method to decide if one is a permutation of the other one.
 */
public class CheckPermutation {
    public boolean isPermutation(String a, String b) {
        //Depends on how to define it, here we take two empty strings as permutation of each other.
        if (a.length() == 0 && b.length() == 0) { return true; }
        if (a.length() == 0 || b.length() == 0) { return false; }
        //Permutation strings need to have the same length
        if (a.length() != b.length()) { return false; }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character c : a.toLowerCase().toCharArray()) {
            if (c == ' ') { continue; }
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        for (Character c : b.toLowerCase().toCharArray()) {
            if (c == ' ') { continue; }
            if (!map.containsKey(c) || map.get(c) <= 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    /*
        Sort an input string is O(nlogn) time, n stands for the string size.
    */
    public boolean isPermutationSort(String a, String b) {
        if (a.length() == 0 && b.length() == 0) { return true; }
        if (a.length() == 0 || b.length() == 0) { return false; }
        //Permutation strings need to have the same length
        if (a.length() != b.length()) { return false; }
        return sort(a).equals(sort(b));
    }
    private String sort(String a) {
        char[] charArray = a.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}

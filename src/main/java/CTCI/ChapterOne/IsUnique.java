package CTCI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jianye on 10/22/16.
 * Implement an algorithm that can determine if a string has all unique characters. What if you cannot use additional
 * data structures?
 */

/**
 *  When it comes to string character questions, always need to clarify if the string is an ascii string, or subset that
 *      contains only a-zA-Z, or superset which is a unicode string.
 *  ASCII code? 0 - 127, or extended ASCII code from 127 to 255? Either way it can be represented by an integer.
 *  if it is a ascii string, we can use an array of size 128 or 256:
 *      If it is an existence or not test, boolean array is enough.
 *      If count of characters matter, use an integer array.
 *  If the string contains only a-zA-Z and is case insensitive, and the problem is existence related, it means there are
 *      only 26 coding positions, we can use an integer (32 bits) to represent a bit vector.
 */
public class IsUnique {
    public boolean isUnique(String s) {
        Set<Character> hashSet = new HashSet<Character>();
        for (Character c : s.toCharArray()) {
            if (hashSet.contains(c)) {
                return false;
            }
            hashSet.add(c);
        }
        return true;
    }

    public boolean isUniqueArray(String s) {
        //ascii only
        //existence check only, if count is also taken into consideration, use integer array.
        boolean[] array = new boolean [128];
        //Space complexity is O(1)
        //Time complexty is O(min(c, n)) n is the number of characters in s, c is the number of characters in the character
        //set. In this case, the time complexity can never be larger than O(128), which we can think as O(1), constant time.
        for (Character c : s.toLowerCase().toCharArray()) {
            if (array[c]) { return false; }
            array[c] = true;
        }
        return true;
    }

    public boolean isUniqueBitVector(String s) {
        //If string is consisted of a-zA-Z and is case insensitive, use a bit vector.
        if (s.length() > 26) { return false; }
        int mark = 0;
        for (Character c : s.toLowerCase().toCharArray()) {
            if ((mark & (1 << (c - 'a'))) != 0) {
                return false;
            }
            mark |= (1 << (c - 'a'));
        }
        return false;
    }

    public boolean isUniqueArraySort(String s) {
        if (s.length() <2 ) { return true; }
        char[] charArray = s.toCharArray();
        //sort the string first, O(nlogn) time
        Arrays.sort(charArray);
        char prev = (char)(charArray[0] + 1);
        for (Character c : charArray) {
            if (c == prev) {
                return false;
            }
            prev = c;
        }
        return true;
    }
}

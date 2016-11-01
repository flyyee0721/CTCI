package CTCI.ChapterOne;

/**
 * Created by jianye on 10/25/16.
 * There are three types of edits that can be performed on strings: insert a character, remove a character and replace a
 * character with another one. Given two strings, write a function to check if they are one edit(or zero edits) away.
 * Example:
 * pale, ple -> true
 * pales, pale -> true
 * pale , bale -> true
 * pale, bae -> false
 * key words:
 *      Two strings, insert a character, remove a character, replace a character
 *      Convert one string to the other.
 * Requirement:
 *      Check if by applying the above three operations one time, one string can be converted to the other.
 * Example:
 *      pale, bae -> check on first letter, p is different from b, 1> replace p with b, bale -> bae, the rest have to be exactly the same
 *                                                                 2> insert p to bae if second string is shorter
 *                                                                 3> insert b to pale if first string is shorter
 *                                                                 4> delete p from pale, compare the rest wtih bae
 *                                                                 5> delete b from bae, compare the rest with pale
 *
 * Sub problems:
 *      1. Compre the current char
 *      2. Apply the same check to the substring
 * Clarification:
 *
 * Corner cases:
 *
 */
public class OneAway {
    public boolean check(String a, String b) {
        //If sizez vary by more than one, return false
        if (Math.abs(a.length() - b.length()) > 1) { return false;}
        if (a.length() == 0 || b.length() == 0) { return true; }
        if (a.equals(b)) { return true; }
        boolean ret = false;
        if (a.charAt(0) == b.charAt(0)) {
            ret = check(a.substring(1), b.substring(1));
            if (ret) { return true; }
        } else {
            ret = a.substring(1).equals(b.substring(1));
            if (ret) { return true; }
            ret = a.equals(b.substring(1));
            if (ret) { return true; }
            ret = a.substring(1).equals(b);
            if (ret) { return true; }
        }
        return false;
    }
}

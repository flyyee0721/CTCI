package CTCI.ChapterOne;

import sun.jvm.hotspot.utilities.Assert;

/**
 * Created by jianye on 10/25/16.
 * Implement a method to perform basic string compression using the counts of repeating characters. aabccddeff would become
 * a2b1c2d2e1f2. If the compressed string is not smaller than the original string, method should return the original string.
 * key words:
 *  string, compression, count of characters.
 * Required output:
 *  Return the compressed string, using char1count1char2count2 format
 * Example:
 *  aabbcceeffeem =>
 *  a2b2c2e2f2e2m1
 * Sub Problem:
 *  Iterate through the string, keep tracking the number of repeating characters.
 * Clarification:
 *
 * Corner case:
 * -
 */
public class StringCompression {
    public String compress(String a) {
        int count = 1;
        char prev = a.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (char c : a.substring(1).toCharArray()) {
            if (c == prev) { count++; }
            else {
                sb.append(prev);
                sb.append(count);
                count = 1;
                prev = c;
            }
        }
        sb.append(prev);
        sb.append(count);
        //If not compressed, return the original string.
        return (a.length() > sb.length()) ? sb.toString() : a;
    }
}

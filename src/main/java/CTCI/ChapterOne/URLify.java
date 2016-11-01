package CTCI;

/**
 * Created by jianye on 10/23/16.
 * Write a method to replace all spaces in a string with '%20'. You may assume that
 * the string has sufficient space at the end to hold the additional characters and that
 * you are given the true length of the string
 * Use a character array if implementing in java, because you can perform this operation in place.
 */
/**
 * Key words:
    String, %20
 * Requirement:
 *  Replace all spaces with %20.
 * Clarification:
 *  1. Continuous spaces with a single %20?
 *  2. Spaces at head and tail should also be replaced with %20?
 *  3. In place? Cannot creat new strings. Do it from front or back?
 *  4. True length of the string means where the string ends.
 */

/**
 *  Why does the solution that starting from the end work?
 *  ABC DEF \0   ABC%20DEF%20G\0
 *  The string that is used to replace white spaces is longer than the original string itself.
 *  If staring from head, the new string will take up spaces of characters that have not been visited
 *  yet. Starting from the back, and on the new string end, overlapping wont happen.
 *  If the replacing string is shorter, we can start from the start, because the positions of the new strings
 *  will not reach the unvisited characters.
 */
public class URLify {
    public char[] exec(char[] array, int length) {
        //Two scans, first to scan the number of spaces and calculate the new length.
        //Since the solution needs to be in place,

        int count = 0;
        for (Character c : array) {
            count +=(c == ' ' ? 1 : 0);
        }
        int pos = length + count * 2 - 1;
        for (int i = length - 1; i >=0 ; i--) {
            if (array[i] != ' ')  {
                array[pos--] = array[i];
            } else {
                array[pos--] = '0';
                array[pos--] = '2';
                array[pos--] = '%';
            }
        }
        return array;
    }
}

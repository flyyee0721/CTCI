package CTCI;

/**
 * Created by jianye on 10/23/16.
 * Given a string, check if it is the permutation of a palindrome.
 * Palindrome string is a string that is symmetric, or reads the same from left and right.
 * e.g. abcddcba
 */
public class PalindromePermutation {
    boolean isPalindromePermutation(String s) {
        //Is the string ascii only? or a-zA-Z? case sensitive or not?
        //Assume it is case insensitive, to check if it is palindrome permutation, count the number of characters,
        //case one is all characters appear even times, case two is only one character appears odd times and all
        //others appear even times.
        int[] array = new int[256];
        for (Character c : s.toLowerCase().toCharArray()) {
            array[c]++;
        }
        boolean hasMetOdd = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                if (hasMetOdd)  {
                    return false;
                } else {
                    hasMetOdd = true;
                }
            }
        }
        return true;
    }

    boolean isPalindromePermutationBitVector(String s) {
        //The key point is that instead of calculating the count, all we need to know is if the value is odd or even.
        //Thus we can use a bit vector to achieve the goal.
        //Assume that we have characters from a-zA-Z
        int bit = 0;
        for (Character c : s.toLowerCase().toCharArray()) {
            int index = c - 'a';
            //if 0, even, flip to 1
            if ((bit & (1 << index))== 0) {
                bit |= (1 << index);
            } else {
                //if 1, odd, flip to 0.
                bit &= ~(1 << index);
            }
            //bit == 0 is to check if all counts are even
            return (bit == 0 ) || (bit & (bit - 1)) == 0;
        }
    }
}

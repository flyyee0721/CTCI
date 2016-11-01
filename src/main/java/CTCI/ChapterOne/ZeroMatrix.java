package CTCI.ChapterOne;

/**
 * Created by jianye on 10/25/16.
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0
 * Key words:
 *  matrix of integers, MxN,
 * Requirement:
 *  If an element is 0, entire row/column is set to zero
 * Example:
 *   1 2 3 0 5
 *   2 4 0 1 3   =>
 *   3 4 5 6 7
 *
 *   0 0 0 0 0
 *   2 4 0 0 3
 *   3 4 5 0 7
 */
public class ZeroMatrix {
    //primitive solution
    //Two pass, first pass to mark the row and columns that are going to be set to 0
    //Second pass, go through all elements,
    //Improved: instead of using extra data structures, use the first row and column as the helping array
    public void setZero(int[][] matrix) {
        boolean hasZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    hasZero = true;
                }
            }
        }
        if (hasZero) {
            for (int i = 1; i < matrix.length; i++)  {
                for (int j = 1; j < matrix[0].length;j++) {
                    if (matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                    if (matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

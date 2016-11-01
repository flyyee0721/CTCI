package CTCI.ChapterOne;

/**
 * Created by jianye on 10/25/16.
 * Gvien an image represented by an NxN matrix, where each pixel in the image is 4 bytes(an integer), write a method to
 * rotate the image by 90 degrees. Can you do this in place?
 * Key words:
 *  N by N matrix of integers
 * Requirements:
 *  Rotate the matrix by 90 degrees
 * Example:
      Aassume we are rotating in a clockwise order.
      1 2 3 4 5
      6 7 8 9 1
      1 3 5 7 9    =>
      2 4 6 8 1
      2 9 0 1 3

      2 2 1 6 1
      9 4 3 7 2
      0 6 5 8 3
      1 8 7 9 4
      3 1 9 1 5
 *
 * Sub problem:
 *    Rotate can be solved layer by layer.
 *    Use a int[N] array to memorize the
 * Clarification:
 *
 * Corner cases:
 *
 * Key points:
 *  rotate layer by layer
 *  use offset to track the distance.
 *
 */
public class RotateMatrix {
    public boolean rotate(int[][] matrix) {
        int N = matrix.length;
        for (int layer = 0; layer < N/2; layer++) {
            //process layer by layer.
            //Last element on the layer is excluded.
            for (int j = layer; j < N - layer - 1; j++ ) {
                //Use offset to track the shift from starting point
                int offset = j - layer;
                int top = matrix[layer][j];
                matrix[layer][j] = matrix[N - layer - 1 - offset][layer];
                matrix[N - layer - 1 - offset][layer] = matrix[N - layer - 1][N - layer - 1 - offset];
                matrix[N - layer - 1][N - layer - 1 - offset] = matrix[layer + offset][N - layer - 1];
                matrix[layer + offset][N - layer - 1] = top;
                //top: (layer, j)
                //right: (layer + offset, N - layer - 1)
                //bottom: (N - layer - 1, N - layer - 1 - offset)
                //left: (N- layer - 1 - offset, layer)
            }
        }
        return true;
    }
}

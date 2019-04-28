O(n ^ 2)

class Solution {
    public void rotate(int[][] matrix) {
        int L = matrix.length;
        for (int i = 0; i < L/2; i ++){
            for (int j = 0; j < (L + 1)/2; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[L - j - 1][i];
                matrix[L - j - 1][i] = matrix[L - i - 1][L - j - 1];
                matrix[L - i - 1][L - j - 1] = matrix[j][L - i - 1];
                matrix[j][L - i - 1] = temp;
            }
        }
    }
}

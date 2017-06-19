package binarySearch;

public class searchMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int xLength = matrix[0].length;
        int yLength = matrix.length;
        int start = 0;
        int end = (xLength * yLength) - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            int value = matrix[mid / xLength][mid % xLength];
            if (value == target){
                return true;
            } else if (value < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start / xLength][start % xLength] == target){
            return true;
        } else if (matrix[end / xLength][end % xLength] == target){
            return true;
        }
        return false;
    }
}


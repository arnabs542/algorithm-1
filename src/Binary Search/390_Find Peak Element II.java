public class Solution {
    /*
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        List<Integer> result = new ArrayList<Integer>();
        int rowStart = 0;
        int rowEnd = A.length - 1;
        int colStart = 0;
        int colEnd = A[0].length - 1;
        // 1. pick a row
        int rowIndex = rowStart + (rowEnd - rowStart)/2;
        // 2. find row peak 
        int colIndex = findRowPeak(A, rowIndex, colStart, colEnd); 
        findHelper(A, rowIndex, colIndex, result);
        return result;
    }
    
    private void findHelper(int[][]A, int rowIndex, int colIndex, List<Integer> result){
        if (colIndex <= 0 || colIndex >= A[0].length - 1) return;
        if (rowIndex <= 0 || rowIndex >= A.length - 1) return;
        
        // 2. check peak found
        if (isPeak(A, rowIndex, colIndex)){
            result.add(rowIndex);
            result.add(colIndex);
            return;
        }
        // 3. find peak in column
        if (A[rowIndex][colIndex] < A[rowIndex + 1][colIndex]){
            rowIndex = findColPeak(A, colIndex, rowIndex + 1, A.length - 1);
        } 
            
        if (A[rowIndex][colIndex] < A[rowIndex - 1][colIndex]){
            rowIndex = findColPeak(A, colIndex, 0, rowIndex - 1);
        }
        
        // 4. check if peak found
        if (isPeak(A, rowIndex, colIndex)){
            result.add(rowIndex);
            result.add(colIndex);
            return;
        }
        
        if (A[rowIndex][colIndex] < A[rowIndex][colIndex + 1]){
            colIndex = findRowPeak(A, colIndex, colIndex + 1, A[0].length - 1);
        } 
            
        if (A[rowIndex][colIndex] < A[rowIndex][colIndex - 1]){
            colIndex = findRowPeak(A, colIndex, 0, colIndex - 1);
        }
        
        findHelper(A, rowIndex, colIndex, result);
    }
    private boolean isPeak(int[][] A, int row, int col){
        //確認邊界, 在邊界上的點不會是peak
        if (col <= 0 || col >= A[0].length - 1) return false;
        if (row <= 0 || row >= A.length - 1) return false;
        if (A[row][col] > A[row + 1][col] 
            && A[row][col] > A[row - 1][col]
            && A[row][col] > A[row][col + 1]
            && A[row][col] > A[row][col - 1]){
               return true; 
            }
        return false;
        }
        
    private int findRowPeak(int[][] A, int rowIndex, int start, int end){
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if (A[rowIndex][mid] > A[rowIndex][mid + 1] && A[rowIndex][mid] > A[rowIndex][mid - 1]){
                return mid;
            } 
            if (A[rowIndex][mid] < A[rowIndex][mid + 1]) start = mid + 1;
            if (A[rowIndex][mid] < A[rowIndex][mid - 1]) end = mid - 1;
            
        }
        if (A[rowIndex][start] > A[rowIndex][end]){
            return start;
        } else {
            return end;
        }
    }
    
    private int findColPeak(int[][] A, int colIndex, int start, int end){
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if (A[mid][colIndex] > A[mid + 1][colIndex] && A[mid][colIndex] > A[mid - 1][colIndex]){
                return mid;
            }
            if (A[mid][colIndex] < A[mid + 1][colIndex]) start = mid + 1;
            if (A[mid][colIndex] < A[mid - 1][colIndex]) end = mid - 1;
        }
        
        if (A[start][colIndex] > A[end][colIndex]){
            return start;
        } else {
            return end;
        }
    }
    
    
}

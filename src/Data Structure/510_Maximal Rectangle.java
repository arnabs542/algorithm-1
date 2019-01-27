// O(N^2)

public class Solution {
    /**
     * @param matrix: a boolean 2D matrix
     * @return: an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[i].length; j ++){
                if (matrix[i][j]){
                    if (i == 0){
                        heights[i][j] = 1;
                        continue;
                    }
                    heights[i][j] = heights[i - 1][j] + 1;
                } else {
                    heights[i][j] = 0;
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < heights.length; i ++){
            max = Math.max(getMaxRectangle(heights[i]), max);
        }
        
        return max;
    }
    
    private int getMaxRectangle(int[] height){
        int curr = 0;
        int max = 0;
        Stack<Integer> s = new Stack<Integer>();
        for (int j = 0; j <= height.length; j ++){
            //System.out.println(height[j]);
            if (j == height.length){
                curr = -1;
            } else {
                curr = height[j];
            }
            
            while (!s.isEmpty() && curr <= height[s.peek()]){
                int h = height[s.pop()];
                int w;
                if (s.isEmpty()){
                    w = j;
                } else {
                    w = j - 1 - s.peek();
                }
                max = Math.max(max, h * w);
            }
            
            s.push(j);
        }
        
        return max;
    }
}

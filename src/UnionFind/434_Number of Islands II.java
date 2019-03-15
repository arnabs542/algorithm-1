/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    
    private int count = 0;
    Point[][] father ;
    int[][] matrix;

    private boolean equal(Point a, Point b){
        return a.x == b.x && a.y == b.y;
    }
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        matrix = new int[n][m];
        father = new Point[n][m];
        List<Integer> result = new ArrayList<Integer>();
        if (operators == null || operators.length == 0){
            return result;
        }
        
        for (int i = 0; i < operators.length; i ++){
            if (i > 0 && equal(operators[i], operators[i - 1])){
                result.add(count);
                continue;
            }
            insertIsland(operators[i]);
            result.add(count);
        }
        
        return result;
    }
    
    private Point findRoot(Point p){
        if (equal(father[p.x][p.y], p)){
            return p;
        }
        
        Point target = p;
        while(!equal(father[target.x][target.y], target)){
            target = father[target.x][target.y];
        }
        
        Point root = target;
        while(!equal(father[p.x][p.y], root)){
            Point temp = father[p.x][p.y];
            father[p.x][p.y]= root;
            p = temp;
        }
        
        return root;
    }
    
    private void insertIsland(Point p){
        // check 4 directions to find any island?
        // if there is island, connect to the island
        int[] rowDelta = {1, -1, 0, 0};
        int[] colDelta = {0, 0, 1, -1};
        int row = matrix.length;
        int col = matrix[0].length;
        matrix[p.x][p.y] = 1;
        father[p.x][p.y] = p;

        count ++;
        
        for (int i = 0; i < 4; i ++){
            int newRow = p.x + rowDelta[i];
            int newCol = p.y + colDelta[i];
            if (newRow > row - 1 || newRow < 0 || newCol > col - 1 || newCol < 0){
                continue;
            }
            if (matrix[newRow][newCol] == 1){
                Point root = findRoot(new Point(newRow, newCol));
                Point pRoot = findRoot(p);
                
                if (!equal(father[pRoot.x][pRoot.y], root)){
                    father[pRoot.x][pRoot.y] = root;
                    count --;
                }
            } 
        }
    }
}

class Element{
    public int row;
    public int col;
    public int val;
    static int isIsland = 1;
    static int isWater = 0;

    public Element(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Solution {
    /**
     * @param grid: a 2D array
     * @return: the maximum area of an island in the given 2D array
     */
    int[] rowMove = {1, -1, 0, 0};
    int[] colMove = {0, 0, 1, -1};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                if (grid[i][j] == Element.isIsland){
                    maxArea = Math.max(maxArea, BFS(grid, new Element(i, j)));
                }
            }
        }
        
        return maxArea;
    }
    
    private int BFS(int[][] grid, Element e){
        Queue<Element> q = new LinkedList<Element>();
        q.offer(e);
        grid[e.row][e.col] = Element.isWater;

        int area = 1; 
        
        while(!q.isEmpty()){
            Element thisE = q.poll();
            for (int i = 0; i < 4; i ++){
                int newRow = thisE.row + rowMove[i]; 
                int newCol = thisE.col + colMove[i];
                if (newRow < 0 || newRow > grid.length - 1 || newCol < 0 || newCol > grid[0].length - 1 ){
                    continue;
                }
            
                if (grid[newRow][newCol] == Element.isIsland){
                    q.offer(new Element(newRow, newCol));
                    grid[newRow][newCol] = Element.isWater;
                    area ++;
                }
            }
        }
        
        return area;
    }
}

class Cell{
    int row;
    int col;
    int h;
    public Cell(int row, int col, int h){
        this.row = row;
        this.col = col;
        this.h = h;
    }
}
public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
     
    private Comparator<Cell> compareCell = new Comparator<Cell>(){
        public int compare(Cell c1, Cell c2){
            return c1.h - c2.h;
        }
    };
    
    public int trapRainWater(int[][] heights) {
        if (heights.length == 0 || heights[0].length == 0){
            return 0;
        }
        // 先把外圈的放進priority queue 和標記成 visited; 
        PriorityQueue<Cell> q = new PriorityQueue<Cell>(compareCell);
        int[][] visited = new int[heights.length][heights[0].length];
        
        
        for (int i = 0; i < heights.length; i ++){ //左右邊界
            q.add(new Cell(i, 0, heights[i][0]));
            q.add(new Cell(i, heights[0].length - 1, heights[i][heights[0].length - 1]));
            visited[i][0] = 1; 
            visited[i][heights[0].length - 1] = 1; 
        }
        
         for (int i = 1; i < heights[0].length - 1; i ++){ //上下邊界
            q.add(new Cell(0, i, heights[0][i]));
            q.add(new Cell(heights.length - 1, i, heights[heights.length - 1][i]));
            visited[0][i] = 1; 
            visited[heights.length - 1][i] = 1; 
        }
        
        // 檢查每個點的四邊, 比較高的放進Priority Queue, 比較矮的記為可以盛水 
        int[] rowMove = new int[]{1, -1, 0, 0};
        int[] colMove = new int[]{0, 0, 1, -1};
        int count = 0;
        while(!q.isEmpty()){
            Cell c = q.poll();
            for (int i = 0; i < 4; i ++){
                int newRow = c.row + rowMove[i];
                int newCol = c.col + colMove[i];
                if (newRow >= 0 && newRow < heights.length 
                    && newCol >= 0 && newCol < heights[0].length){
                        if (visited[newRow][newCol] == 1){
                            continue;
                        } else {
                            visited[newRow][newCol] = 1;
                        }
                        
                        if (c.h > heights[newRow][newCol]){
                            count = count + c.h - heights[newRow][newCol];
                        }
                        
                        q.offer(new Cell(newRow, newCol, Math.max(heights[newRow][newCol], c.h)));
                    }
            }
        }
        
        return count;
    }
}

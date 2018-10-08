package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

class Coordinate{
    int x;
    int y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
/**
 * Created by epingho on 2017/7/4.
 */
public class NumberofIslands {
    public int numIslands(boolean[][] grid) {
        //grid.length => Y
        //grid[0].length => x
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int islandCount = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j]){
                    BFS(grid, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    public void BFS(boolean[][] grid, int x, int y){
        int[] coordinateX = {0, 0, 1, -1};
        int[] coordinateY = {1, -1, 0, 0};

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        grid[x][y] = false;

        while (!queue.isEmpty()){
            Coordinate thisI = queue.poll();
            for (int i = 0; i < 4; i++){
                //check the coordinate is within boundry
                int neighborX = thisI.x + coordinateX[i];
                int neighborY = thisI.y + coordinateY[i];
                if (neighborX > grid.length -1
                        || neighborX < 0
                        || neighborY > grid[0].length -1
                        || neighborY < 0){
                    continue;
                }
                if (grid[neighborX][neighborY]){
                    queue.offer(new Coordinate(neighborX, neighborY));
                    grid[neighborX][neighborY] = false;
                }
            }
        }
    }
}



class Coordinate{
    int x;
    int y;
    boolean island;
    
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        int numIslands = 0;
        
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[i].length; j ++){
                if (grid[i][j]){
                    BFS(grid, new Coordinate(i, j));
                    numIslands ++;
                }
            }
        }
        
        return numIslands;
    }
    
    private void BFS(boolean[][] grid, Coordinate thisIsland){
        Queue<Coordinate> q = new LinkedList<Coordinate>();
        q.offer(thisIsland);
        while(!q.isEmpty()){
            Coordinate c = q.poll();
            if (c.x + 1 < grid.length && grid[c.x + 1][c.y]){
                grid[c.x + 1][c.y] = false;
                q.offer(new Coordinate(c.x + 1, c.y));
            }
            if (c.x - 1 >= 0 && grid[c.x - 1][c.y]){
                grid[c.x - 1][c.y] = false;
                q.offer(new Coordinate(c.x - 1, c.y));
            }
            if (c.y + 1 < grid[0].length && grid[c.x][c.y + 1]){
                grid[c.x][c.y + 1] = false;
                q.offer(new Coordinate(c.x, c.y + 1));
            }
            if (c.y - 1 >= 0 && grid[c.x][c.y - 1]){
                grid[c.x][c.y - 1] = false;
                q.offer(new Coordinate(c.x, c.y - 1));
            }
        }
    }
    
}

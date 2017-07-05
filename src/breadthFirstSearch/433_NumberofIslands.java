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

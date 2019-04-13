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

//// DFS
// O(R * C)
// R: the number of rows
// C: the number of columns
class Solution {
    private int[] rowDelta = {0, 0, 1, -1};
    private int[] colDelta = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i ++){ 
            for (int j = 0; j < grid[i].length; j ++){
                if (grid[i][j] == '1'){
                    
                    DFS(grid, i, j);
                    count ++;
                }
            }
        }
        
        return count;
    }
    
    private void DFS(char[][] grid,
                    int row,
                    int col){
        
        if (grid[row][col] == '0'){
            return;
        }
        
        grid[row][col] = '0';
        for (int i = 0; i < 4; i ++){
            int newR = row + rowDelta[i];
            if (newR < 0 || newR > grid.length - 1){
                continue;
            }
            
            int newC = col + colDelta[i];
            if (newC < 0 || newC > grid[0].length - 1){
                continue;
            }
            
            if (grid[newR][newC] == '0'){
                continue;
            }
            
            DFS(grid, newR, newC);
        }
    }
}

//// Union find
class Solution {
    private void union(int a, int b){
        int root_a = findRoot(a);
        int root_b = findRoot(b);
        if (root_a != root_b){
            hm.put(root_a, root_b);
        }
    }
    
    private int findRoot(int a){
        if (hm.get(a) == a){
            return a;
        }
        
        int target = a;
        while (hm.get(target) != target){
            target = hm.get(target);
        }
        
        int root = target;
        while (hm.get(a) != target){
            int temp = hm.get(a);
            hm.put(a, target);
            a = temp;
        }
        
        return root;
    }
    
    int islandCount = 0;
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int rCount = grid.length;
        int cCount = grid[0].length;
        // 1. create a hashmap to store island and its father mapping
        // map all the island to its father at beggining;
        for (int i = 0; i < rCount; i ++){
            for (int j = 0; j < cCount; j ++){
                if (grid[i][j] == '1'){
                    int coordinate = i * rCount + j;
                    hm.put(coordinate, coordinate);
                }
            }   
        }
            
        // 2. loop through all the nodes
        for (int i = 0; i < rCount; i ++){
            for (int j = 0; j < cCount; j ++){
                if (grid[i][j] == '1'){
                    // if the island have adjunction 1, union it
                    if (i + 1 < rCount && grid[i + 1][j] == '1'){
                        union(i * rCount + j, (i + 1) * rCount + j);
                    }
                    
                    if (j + 1 < cCount && grid[i][j + 1] == '1'){
                        union(i * rCount + j, i * rCount + j + 1);
                    }
                }
            }   
        }
        
        HashSet<Integer> result = new HashSet<Integer>();
        for (int i : hm.keySet()){
            if (i == hm.get(i)){
                result.add(i);
            }
        }
        
        return result.size();
    }
    

}


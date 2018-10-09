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
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (source == null ||
            grid == null ||
            destination == null ||
            grid.length == 0){
                return -1;
            }
        
        int[] xMove = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] yMove = {2, -2, 2, -2, 1, -1, 1, -2};
        
        int step = 0;
        Queue<Point> q = new LinkedList<Point>();

        q.offer(source);
        grid[source.x][source.y] = true;

        while(!q.isEmpty()){
            int size = q.size();
            step ++;
            for (int j = 0; j < size; j++){
                Point p = q.poll();
                for (int i = 0; i < 8; i ++){
                    Point newP = new Point(p.x + xMove[i], p.y + yMove[i]);
                    if (isInBound(grid, newP)){
                        if (isDestination(newP, destination)){
                            return step;
                        } else{
                            if (!isBarrier(grid, newP)){
                                q.offer(newP);
                                grid[newP.x][newP.y] = true;
                            }
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean isInBound(boolean[][] grid, Point p){
        return (p.x < grid.length && p.x >= 0 && p.y < grid[0].length && p.y >= 0);
    }
    
    private boolean isBarrier(boolean[][] grid, Point p){
        return (grid[p.x][p.y]);
    }
    
    private boolean isDestination(Point p, Point d){
        return (p.x == d.x && p.y == d.y);
    }
}

package breadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by epingho on 2017/7/5.
 */
public class KnightShortestPath {
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (source == null
                || destination == null
                || grid == null
                || grid.length == 0){
            return -1;
        }

        int[] moveX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] moveY = {2, -2, 2, -2, 1, -1, 1, -1};

        Queue<Point> thisQ = new LinkedList<>();
        HashSet<Point> hash = new HashSet<>();

        thisQ.offer(source);
        int steps = 0;

        while (!thisQ.isEmpty()){
            int qSize = thisQ.size();
            for (int j = 0; j < qSize; j ++){
                Point thisPoint = thisQ.poll();
                if (thisPoint.x == destination.x
                        && thisPoint.y == destination.y){
                    return steps;
                }
                for (int i = 0; i < 8; i++){
                    Point newPoint = new Point(thisPoint.x + moveX[i]
                            , thisPoint.y + moveY[i]);
                    // check boundry
                    if (newPoint.x < 0
                            || newPoint.x >= grid.length
                            || newPoint.y < 0
                            || newPoint.y >= grid[0].length){
                        continue;
                    }

                    if (grid[newPoint.x][newPoint.y]){
                        continue;
                    }

                    grid[newPoint.x][newPoint.y] = true;
                    thisQ.offer(newPoint);
                }
            }
            steps ++;
        }
        return -1;
    }

}

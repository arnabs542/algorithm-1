package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * *** get People Count;
 */

public class ZombieInMatrix {

    public int PEOPLE = 0;
    public int ZOMBIE = 1;
    public int WALL = 2;
    int[] coordinateX = {0, 0, 1, -1};
    int[] coordinateY = {1, -1, 0, 0};

    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        Queue<Coordinate> zumbieQ = new LinkedList<>();

        int peopleCount = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == PEOPLE){
                    peopleCount ++;
                }
                else if (grid[i][j] == ZOMBIE){
                    zumbieQ.offer(new Coordinate(i, j));
                }
            }
        }

        if (peopleCount == 0){
            return 0;
        }

        int dayCount = 0;
        while (!zumbieQ.isEmpty()){
            dayCount ++;
            int size = zumbieQ.size();
            for (int k = 0; k < size; k++ ){
                Coordinate thisCoordinate = zumbieQ.poll();
                for (int i = 0; i < 4; i++){

                    int neighborX = thisCoordinate.x + coordinateX[i];
                    int neighborY = thisCoordinate.y + coordinateY[i];

                    if (neighborX < 0
                            || neighborX > grid.length -1
                            || neighborY < 0
                            || neighborY > grid[0].length -1){
                        continue;
                    }
                    if (grid[neighborX][neighborY] == PEOPLE){
                        grid[neighborX][neighborY] = 1;
                        peopleCount --;
                        if (peopleCount == 0){
                            return dayCount;
                        }
                        zumbieQ.offer(new Coordinate(neighborX, neighborY));
                    }
                }
            }
        }

        return -1;
    }
}

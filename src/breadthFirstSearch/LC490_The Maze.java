class Coordinate{
    public int row;
    public int col;
    public Coordinate(int r, int c){
        this.row = r;
        this.col = c;
    }
}



class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return BFS(maze, start, destination);
    }
    
    private boolean BFS(int[][] maze, int[] start, int[] destination){
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Coordinate> q = new LinkedList<Coordinate>();
        q.offer(new Coordinate(start[0], start[1]));
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i ++){
                Coordinate c = q.poll();
                List<Coordinate> next = getNext(c, maze);
                
                if (next == null || next.size() == 0){
                    continue;
                }
                
                for (Coordinate n: next){
                    if (n.row == destination[0] && n.col == destination[1]){
                        return true;
                    }
                    if (visited[n.row][n.col]){
                        continue;
                    }
                    q.offer(n);
                    visited[n.row][n.col] = true;
                }
            }
        }
        
        return false;
    }
    private int[] rowDelta = {0, 0, 1, -1};
    private int[] colDelta = {1, -1, 0, 0};
    private List<Coordinate> getNext(Coordinate c, int[][] maze){
        List<Coordinate> result = new ArrayList<>();
        for (int i = 0; i < 4; i ++){
            int newR = c.row;
            int newC = c.col;
            boolean newCoordinate = false;
           while (newR < maze.length
                && newR >= 0 
                && newC < maze[0].length
                && newC >= 0
                && maze[newR][newC] == 0){
               newR = newR + rowDelta[i];
               newC = newC + colDelta[i];
            }
            
            newR = newR - rowDelta[i];
            newC = newC - colDelta[i];
            
            result.add(new Coordinate(newR, newC));
            
        } 
        return result;
    }
}

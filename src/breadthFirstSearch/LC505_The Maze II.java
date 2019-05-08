class Coor{
    int row;
    int col;
    int l;
    public Coor(int row, int col, int length){
        this.row = row;
        this.col = col;
        this.l = length;
    }
}
class Solution {
    private int[] drow = {0, 0, 1, -1};
    private int[] dcol = {1, -1, 0, 0};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int shortest = Integer.MAX_VALUE;
        int[][] visited = new int[maze.length][maze[0].length];
        for (int i = 0; i < visited.length; i ++){
            for (int j = 0; j < visited[i].length; j ++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        
        Queue<Coor> q = new LinkedList<Coor>();
        q.offer(new Coor(start[0], start[1], 0));
        visited[start[0]][start[1]] = 0;
        
        while (!q.isEmpty()){
            Coor c = q.poll();
            for (int i = 0; i < 4; i ++){
                int newR = c.row;
                int newC = c.col;
                int step = c.l;
                while (newR < maze.length 
                      && newR >= 0
                      && newC < maze[0].length
                      && newC >= 0
                      && maze[newR][newC] == 0){
                    newR = newR + drow[i];
                    newC = newC + dcol[i];
                    step ++;
                }
                newR = newR - drow[i];
                newC = newC - dcol[i];
                step = step -1;
                
                if (newR == destination[0] && newC == destination[1]){
                    if (step < visited[newR][newC]){
                        visited[newR][newC] = step;
                    }
                    continue; 
                }
                
                //**** visited存的是長度, 如果新的步數比原來的大 or 相等, 那可以跳過
                if (step >= visited[newR][newC] || step == 0){
                    continue;
                }
                
                q.offer(new Coor(newR, newC, step));
                visited[newR][newC] = step;
            }
        }
        
        if(visited[destination[0]][destination[1]] == Integer.MAX_VALUE){
            return -1;   
        } 
    
        return visited[destination[0]][destination[1]];
    }
    
    
}

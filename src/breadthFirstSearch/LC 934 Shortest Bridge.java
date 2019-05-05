class Element{
    public int row;
    public int col;
    public Element(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    private int[] rowDelta = {0, 0, 1, -1};
    private int[] colDelta = {1, -1, 0, 0};
    
    public int shortestBridge(int[][] A) {
        // 先找到一個小島, 把這個島的格子都加入q
        // 然後填海造陸, 看要造幾次會找到下一個1 
        Queue<Element> q = new LinkedList<Element>();
        boolean found = false;
        for (int i = 0; i < A.length; i ++){
            for (int j = 0; j < A[i].length; j ++){
                if (A[i][j] == 1 && !found){
                    DFS(A, i, j, q);
                    found = true;
                } 
            }   
        }
        
        return BFS(A, q);
    }
    
    private void DFS(int[][] A, int row, int col, Queue<Element> q){
        if (row > A.length -1 || row < 0 || col > A[row].length -1 || col < 0){
            return;
        }
        
        if (A[row][col] != 1){
            return;
        }
        
        q.offer(new Element(row, col));
        A[row][col] = -1;
        
        for (int i = 0; i < 4; i ++){

            DFS(A, row + rowDelta[i], col + colDelta[i], q);
        }
    }
    
    private int BFS(int[][] A, Queue<Element> q){
        int step = 0;
        
        while (!q.isEmpty()){
            int size = q.size();
            step ++;
            for (int i = 0; i < size; i ++){
                Element e = q.poll();
                for (int j = 0; j < 4; j ++){
                    int row = e.row + rowDelta[j];
                    int col = e.col + colDelta[j];
                    if (row > A.length -1 || row < 0 || col > A[0].length -1 || col < 0){
                        continue;
                    }
                    if (A[row][col] == 1){
                        return step - 1;
                    }
                    if (A[row][col] == 0){
                        A[row][col] = -1;
                        q.offer(new Element(row, col));
                    }
                }
            }
        }
        
        return -1;
    }
}

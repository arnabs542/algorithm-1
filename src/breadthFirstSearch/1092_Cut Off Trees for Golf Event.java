class Tree{
    public int r;
    public int c;
    public int h;
    public Tree(int r, int c, int h){
        this.r = r;
        this.c = c;
        this.h = h;
    }
}

public class Solution {
    /**
     * @param forest: a list of integers
     * @return: return a integer
     */
    int[] rowDelta = {1, -1, 0, 0};
    int[] colDelta = {0, 0, 1, -1};
    int VISITED = -1;
    
    private Comparator<Tree> compareTree = new Comparator<Tree>(){
        public int compare(Tree t1, Tree t2){
            return t1.h - t2.h;
        }
    };
    
    public int cutOffTree(List<List<Integer>> forest) {
        int rSize = forest.size();
        int cSize = forest.get(0).size();
        
        // 先給樹的高度排序
        List<Tree> treeList = new ArrayList<>();
        for (int i = 0; i < rSize; i ++){
            for (int j = 0; j < cSize; j ++){
                if (forest.get(i).get(j) > 1){
                    treeList.add(new Tree(i, j, forest.get(i).get(j)));
                }
            }
        }
        
        Collections.sort(treeList, compareTree);
        
        int currR = 0;
        int currC = 0;
        int totalStep = 0;
        // 把每棵樹去BFS
        // 第一次BFS是從(0, 0) 開始
        // 之後是從這次砍掉的樹開始
        for (Tree t: treeList){
            int step = BFS(forest, currR, currC, t);
            if (step == -1){
                return -1; // 這棵樹砍不到
            }
            
            currR = t.r;
            currC = t.c;
            totalStep = totalStep + step;
        }
        
        return totalStep;
        
    }
    
    private int BFS(List<List<Integer>> forest
                    , int row
                    , int col
                    , Tree targetTree){
        
        Queue<Tree> q = new LinkedList<Tree>();
        q.offer(new Tree(row, col, forest.get(row).get(col)));
        
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[row][col] = true;
        // forest.get(row).set(col, VISITED);
        int step = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for (int j = 0; j < size; j ++){
                Tree t = q.poll();
                if (t.r == targetTree.r && t.c == targetTree.c){
                    return step;
                }
                
                for (int i = 0; i < 4; i ++){
                    int newTR = t.r + rowDelta[i];
                    int newTC = t.c + colDelta[i];
                    if (newTR < 0 || newTR > forest.size() - 1 || newTC < 0 || newTC > forest.get(0).size() - 1){
                        continue;
                    }
                
                    int treeH = forest.get(newTR).get(newTC);
                    if (treeH == 0 || visited[newTR][newTC] == true){
                        continue;
                    } 
                    
                    if (treeH >= 1){
                        q.offer(new Tree(newTR, newTC, treeH));
                        visited[newTR][newTC] = true;
                        //forest.get(newTR).set(newTC, VISITED);
                    }
                }
            }
            step ++;
            }
        
        return -1;
    }
}

class Solution {
    int[] father;
    int totalNum;
    private void union(int a, int b){
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b){
            father[root_b] = root_a;
            totalNum --;
        }
    }
    
    private int find(int a){
        if (father[a] == a){
            return a;
        }
        
        int target = a;
        while(father[target] != target){
            target = father[target];
        }
        
        int root = target;
        while (father[a] != root){
            int temp = father[a];
            father[a] = root;
            a = temp;
        }
        
        return root;
        
    }
    
    public int countComponents(int n, int[][] edges) {
        totalNum = n;
        father = new int[n];
        
        for (int i = 0; i < n; i ++){
            father[i] = i;
        }
        
        for (int i = 0; i < edges.length; i ++){
            union(edges[i][0], edges[i][1]);
        }
        
        return totalNum;
        
    }
}

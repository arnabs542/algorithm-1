public class ConnectingGraph2 {
    /*
    1. maintain 2 arrays: father[]; size[]
    2. record size when connect another node to root
    3. get size from root
    */
    
    int[] father;
    int[] size;
    public ConnectingGraph2(int n) {
        father = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i ++){
            father[i] = i;
            size[i] = 1;
        }
    }
    
    private int findRoot(int x){
        int root;
        if (father[x] == x){
            root = x;
            return root;
        }
        
        // find root
        int target = x;
        while (father[target] != target){
            target = father[target];    
        }
        
        // make all child pointing to root
        root = target;
        while (father[x] != root){
            int temp = father[x];
            father[x] = root;
            x = temp;
        }
        
        return root;
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int root_a = findRoot(a);
        int root_b = findRoot(b);
        if (root_a != root_b){
            father[root_a] = root_b;
            size[root_b] = size[root_b] + size[root_a];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        int root_a = findRoot(a);
        return size[root_a];
    }
}

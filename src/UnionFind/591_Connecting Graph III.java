public class ConnectingGraph3 {
    /**
     一開始全部沒有聯通時, connectedComp = n;
     每聯通一個, connectedComp --;
     */
    private int[] father;
    private int connectedComp;
    public ConnectingGraph3(int n){
        father = new int[n + 1];
        connectedComp = n;
        
        for (int i = 1; i <= n; i ++){
            father[i] = i;
        }
    }
    
    private int findRoot(int x){
        if (father[x] == x){
            return x;
        }
        
        int target = x;
        while (father[target] != target){
            target = father[target];
        }
        
        int root = target;
        while (father[x] != x){
            int temp = father[x];
            father[x] = root;
            x = temp;
        }
        
        return root;
    }
    
    public void connect(int a, int b) {
        int root_a = findRoot(a);
        int root_b = findRoot(b);
        if (root_a != root_b){
            father[root_a] = root_b;
            connectedComp --;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        return connectedComp;
    }
}

public class ConnectingGraph {
    /*
    * @param n: An integer
    */
    private int[] father;
    public ConnectingGraph(int n) {
        father = new int[n + 1];
        for (int i = 1; i < n; i ++){
            father[i] = i;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        int root_a = father[a];
        int root_b = father[b];
        if (root_a != root_b){
            for (int i = 1; i < father.length; i ++){
                if(father[i] == root_a){
                    father[i] = root_b;
                }
            }
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        int root_a = father[a];
        int root_b = father[b];
        if (root_a == root_b){
            return true;
        }
        
        return false;
    }
}

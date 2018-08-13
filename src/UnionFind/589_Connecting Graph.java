public class ConnectingGraph {
    private int[] mapToFather = null;
    
    public ConnectingGraph(int n) {
        mapToFather = new int[n];
        for (int i = 0; i < n; i ++){
            mapToFather[i] = i;
        }
    }

    public void connect(int a, int b) {
        int fatherA = mapToFather[a - 1];
        int fatherB = mapToFather[b - 1];
        
        mapToFather[a - 1] = fatherB;
        for (int i = 0; i < mapToFather.length; i ++){
            if (mapToFather[i] == fatherA){
                mapToFather[i] = fatherB;
            }
        }
    }

    public boolean query(int a, int b) {
        int fatherA = mapToFather[a - 1];
        int fatherB = mapToFather[b - 1];
        return fatherA == fatherB;
    }
}

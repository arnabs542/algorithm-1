//O(nlogn)
/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
public class Solution {
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    
    private Comparator<Connection> compareConn = new Comparator<Connection>(){
        public int compare(Connection a, Connection b){
            if (a.cost == b.cost){
                if (a.city1.equals(b.city1)){
                    return a.city2.compareTo(b.city2);
                }
                return a.city1.compareTo(b.city1);
            }
            return a.cost - b.cost;
        }
    };
    
    HashMap<String, String> root = new HashMap<>(); 
    public List<Connection> lowestCost(List<Connection> connections) {
        /* 1. sort connection cost O(logn) // n: # of connections
           2. initialize union find, set hashmap to store city, and its father
           3. loop through sorted connection cost // O(nlogn) // pq.poll(logn)
              if (city a and city b is connected) => continue; 
              else => connected, add the connection to answer; 
        */
        List<Connection> ans = new ArrayList<>();
        PriorityQueue<Connection> pq = new PriorityQueue<Connection>(compareConn);
        for (Connection c: connections){
            root.put(c.city1, c.city1);
            root.put(c.city2, c.city2);
            pq.offer(c);
        }
        
        while(!pq.isEmpty()){
            Connection c = pq.poll();
            if (isConnected(c.city1, c.city2)){
                continue;
            }
            
            connect(c.city1, c.city2);
            ans.add(c);
        }
        
        if (ans.size() == root.size() - 1){
            return ans;
        }
        
        return new ArrayList<>();
    }
    
    private boolean isConnected(String c1, String c2){
        String c1_root = findRoot(c1);
        String c2_root = findRoot(c2);
        return c1_root.equals(c2_root);
    }
    
    private String findRoot(String c){
        if (root.get(c).equals(c)){
            return c;
        } 
        
        String target = c;
        while (!root.get(target).equals(target)){
            target = root.get(target);
        }
        
        String r = target;
        // 從c開始把大家都指向root
        while (!root.get(c).equals(r)){
            String temp = root.get(c);
            root.put(c, r);
            c = temp;
        }
        
        return r;
    }
    
    private void connect(String c1, String c2){
        String c1_root = findRoot(c1);
        String c2_root = findRoot(c2);
        
        root.put(c1_root, c2_root);
    }
    
}

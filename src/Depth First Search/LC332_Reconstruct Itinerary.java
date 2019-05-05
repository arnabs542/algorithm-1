class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> next = new HashMap<>();
        List<String> result = new ArrayList<String>();
        
        for (int i = 0; i < tickets.size(); i ++){
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if (!next.containsKey(from)){
                next.put(from, new PriorityQueue<String>());
            }
            next.get(from).offer(to);
        }
        
        DFS("JFK", next, result);
        
        return result;
    }
    
    private void DFS(String city, HashMap<String, PriorityQueue<String>> next, List<String> result){
        while (next.containsKey(city) && next.get(city).size() > 0){
            DFS(next.get(city).poll(), next, result);
        }
        
        result.add(0, city);
    }
}

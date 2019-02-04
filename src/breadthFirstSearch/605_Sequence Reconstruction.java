public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (seqs.length == 0 || seqs[0].length == 0){
            return (org.length == 0);
        }
        
        HashMap<Integer, Set<Integer>> neighbors = new HashMap<>();
        HashMap<Integer, Integer> dependency = new HashMap<>();
        
        for (int i = 0; i < seqs.length; i ++){
            for (int j = 0; j < seqs[i].length; j ++){
                neighbors.put(seqs[i][j], new HashSet<Integer>());
                dependency.put(seqs[i][j], 0);
            }
        }
        


        for (int i = 0; i < seqs.length; i ++){
            if (seqs[i].length == 1){
                continue;
            }
            for (int j = 1; j < seqs[i].length; j ++){
                int a = seqs[i][j - 1];
                int b =  seqs[i][j];
                                
                neighbors.get(a).add(b);
            }
        }
        
        for (int i : neighbors.keySet()){
            for (int j : neighbors.get(i)){
                dependency.put(j, dependency.get(j) + 1);
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for (Integer i: dependency.keySet()){
            if (dependency.get(i) == 0){
                q.offer(i);
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        while(!q.isEmpty()){
            int size = q.size();
            if (size > 1){
                return false;
            }
            int a = q.poll();
            result.add(a);
            //HashSet<Integer> neighborList = neighbors.get(a);
            for (Integer n : neighbors.get(a)){
                System.out.println(n);

                dependency.put(n, dependency.get(n) - 1);
                if (dependency.get(n) <= 0){
                    q.offer(n);
                }
            }
        }
                
        if (result.size() == 0 || result.size() != org.length){
            return false;
        }
        
        for (int i = 0; i < result.size(); i ++){
            if (result.get(i) != org[i]){
                return false;
            }
        }
        
        return true;
    }
}

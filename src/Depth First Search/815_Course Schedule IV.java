// 找出全部的排列
// DFS permutation

public class Solution {
    /**
     * @param n: an integer, denote the number of courses
     * @param p: a list of prerequisite pairs
     * @return: return an integer,denote the number of topologicalsort
     */
    HashMap<Integer, Integer> dependencyCount = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> next = new HashMap<>();
    
    public int topologicalSortNumber(int n, int[][] p) {
        if (p == null || p.length == 0){
            int ans = 1;
            for (int i = 1; i <= n; i ++){
                ans = ans * i;
            }
            
            return ans;
        }
        
        for (int i = 0; i < n; i ++){
            dependencyCount.put(i, 0);
            next.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < p.length; i ++){
            //p[i][0] : courses
            //p[i][1] : prerequisite
            dependencyCount.put(p[i][0], dependencyCount.get(p[i][0]) + 1);
            next.get(p[i][1]).add(p[i][0]);
        }
        
        boolean[] done = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();
        DFS(n, done, new ArrayList<Integer>(), result);
        
        return result.size();
    }
    
    private void DFS(int n,
                    boolean[] done,
                    List<Integer> subset,
                    List<List<Integer>> result){
        if (subset.size() == n){
            System.out.println(subset);
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        
        for (int i = 0; i < n; i ++){
            if (dependencyCount.get(i) != 0){
                continue;
            }
            if (done[i]){
                continue;
            }
            subset.add(i);
            done[i] = true;
            for (Integer nextCourse: next.get(i)){
                dependencyCount.put(nextCourse, dependencyCount.get(nextCourse) - 1);
            }
            DFS(n, done, subset, result);
            subset.remove(subset.size() - 1);
            done[i] = false;
            for (Integer nextCourse: next.get(i)){
                dependencyCount.put(nextCourse, dependencyCount.get(nextCourse) + 1);
            }
        }
    }
}

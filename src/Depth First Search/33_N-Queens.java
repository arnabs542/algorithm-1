public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        //r0,r1,r2,r3  
        //[1, 3, 0, 4]
        List<List<String>> result = new ArrayList<>();
        DFS(n, result, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void DFS(int n,
                    List<List<String>> result,
                    List<Integer> subset,
                    int nextCol
                    ){
        if (subset.size() == n){
            result.add(new ArrayList<String>(generateResult(n, subset)));
            return;
        }
        
        for (int i = 0; i < n; i ++){
            if (!isValid(n, subset, i)){
                continue;
            }
            
            subset.add(i);
            DFS(n, result, subset, i);
            subset.remove(subset.size() - 1);
        }
    }
                    
    private List<String> generateResult(int n,
                            List<Integer> subset){
        List<String> subsetString = new ArrayList<String>();
        
        for (int j = 0; j < subset.size(); j ++){
            String s = "";
            int q = subset.get(j);
            for (int i = 0; i < n; i ++){
                if (i == q){
                    s = s + "Q";
                } else{
                    s = s + ".";
                }
            }
            subsetString.add(s);
        }
        return subsetString;
                    
    }
    
    private boolean isValid(int n,
                    List<Integer> subset,
                    int nextCol){
        int nextRow = subset.size();

        for (int i = 0; i < subset.size(); i ++){
            int col = subset.get(i);
            int row = i;
            if (nextCol == col){
                return false;
            }
            
            if (nextCol + nextRow == col + row){
                return false;
            }
            
            if (nextCol - nextRow == col - row){
                return false;
            }
        }
        
        return true;
    }
}

// 1, 2, 3, 4 不能相鄰?

public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        if (n == 0){
            return new ArrayList<>();
        }
        
        List<List<String>> stringResult = new ArrayList<>();
        dfs(stringResult, new ArrayList<Integer>(), n);

        return stringResult;
    }
    
    private void dfs(
            List<List<String>> result
            , List<Integer> subset
            , int n
        ){
        
        if (subset.size() == n){
            result.add(buildString(subset));
            return;
        }
        
        for (int col = 0; col < n; col ++){
            if (!isValid(col, subset)){
                continue;
            }
            subset.add(col);
            dfs(result, subset, n);
            subset.remove(subset.size() - 1);
        }
    }

    private boolean isValid(int nextCol, List<Integer> subset){
        int nextRow = subset.size();
        for (int row = 0; row < subset.size(); row ++){
            int col = subset.get(row);
            if (col == nextCol || row == nextRow){
                return false;
            }
            if ((col - row) == (nextCol - nextRow)){
                return false;
            }
            if ((col + row) == (nextCol + nextRow)){
                return false;
            }
        }
        return true;
    }
    
    // [0, 1, 2, 3]
    private List<String> buildString(List<Integer> subset){
        List<String> subsetString = new ArrayList<>();
        for (int i = 0; i < subset.size(); i ++){
            int qPosition = subset.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < subset.size(); j ++){
                if (qPosition == j){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
            }
            subsetString.add(sb.toString());
        }
        return subsetString;
    }
}

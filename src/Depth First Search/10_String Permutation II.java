public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        List<String> result = new ArrayList<String>();
        char[] stringArray = str.toCharArray();
        Arrays.sort(stringArray);
        boolean visited[] = new boolean[stringArray.length];
        Arrays.fill(visited, false);
        
        DFS(result, 
            stringArray, 
            new ArrayList<String>(), 
            visited);
        
        return result;
    }
    
    private void DFS(List<String> result,
                char[] stringArray,
                List<String> subset,
                boolean[] visited){
                    
        if (subset.size() == stringArray.length){
            String subString = "";
            for (int i = 0; i < subset.size(); i++){
                subString = subString + subset.get(i);
            }
            result.add(subString);
            return;
        }
        
        for (int i = 0; i < stringArray.length; i++){
            if (visited[i]){
                continue;
            }
            
            if (i > 0 && stringArray[i] == stringArray[i-1] && visited[i - 1] == false){
                continue;
            }
            
            subset.add(Character.toString(stringArray[i]));
            visited[i] = true;
            DFS(result, 
                stringArray,
                subset,
                visited);
            subset.remove(subset.size() -1);
            visited[i] = false;
        }
        
                    
    }
}

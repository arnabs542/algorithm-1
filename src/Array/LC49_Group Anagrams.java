// O(N * K)
// N: length of strs
// K: max length of string in strs

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>>hm = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String s: strs){
            
            String hashValue = getStringHashValue(s);
            
            if (!hm.containsKey(hashValue)){
                hm.put(hashValue, new ArrayList<String>());
            } 
                
            hm.get(hashValue).add(s);
        }
        
        for (String s: hm.keySet()){
            result.add(hm.get(s));
        }
        
        return result;
    }
    
    private String getStringHashValue(String s){
        StringBuilder hashString = new StringBuilder();
        
        char[] sArray = s.toCharArray();
        int[] count = new int[26];
        Arrays.fill(count, 0);
        
        for (char c: sArray){
            count[c - 'a'] = count[c - 'a'] + 1;
        }
        
        for(int i: count){
            hashString.append(i);
            hashString.append('#');
        }
        
        return hashString.toString();
        
    }
}

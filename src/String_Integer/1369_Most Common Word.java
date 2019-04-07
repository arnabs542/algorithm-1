public class Solution {
    /**
     * @param paragraph: 
     * @param banned: 
     * @return: nothing
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split(" ");
        
        HashSet<String> bannedHs = new HashSet<>();
        for (int i = 0; i < banned.length; i ++){
            bannedHs.add(banned[i].toLowerCase());
        }
        
        int maxCount = Integer.MIN_VALUE;
        String maxString = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < words.length; i ++){
            String w = words[i].toLowerCase().replaceAll("[\\W+]", "");
            if (bannedHs.contains(w)){
                continue;
            }
            int newCount = 1;
            if (hm.containsKey(w)){
                newCount = hm.get(w) + 1;
                hm.put(w, newCount);
            } else {
                hm.put(w, newCount);
            }
            
            if (newCount > maxCount){
                maxCount = newCount;
                maxString = w;
            }
        }
        
        return maxString;
    }
}

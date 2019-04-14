//O(n)
//LC: 904 - Fruit Into Baskets    	

class Solution {
    public int totalFruit(int[] tree) {
        int maxLength = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hm = new HashMap<>(); // treeType, count
        int startIndex = 0;
        for (int i = 0; i < tree.length; i ++){
            int type = tree[i];
            if (hm.containsKey(type)){
                hm.put(type, hm.get(type) + 1);
            } else {
                if (hm.size() < 2){
                    hm.put(type, 1);
                } else {
                    // remove any item in hashmap, as long as one item has count 0; 
                    boolean removeItem = false;
                    while (!removeItem){
                        hm.put(tree[startIndex], hm.get(tree[startIndex]) - 1);
                        if (hm.get(tree[startIndex]) == 0){
                            removeItem = true;
                            hm.remove(tree[startIndex]);
                        }
                        startIndex ++;
                    }
                    
                    hm.put(type, 1);
                }
            }
            
            maxLength = Math.max(maxLength, i - startIndex + 1);
        }
        
        return maxLength;
    }
}

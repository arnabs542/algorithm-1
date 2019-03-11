class TreeNode{
    public Character c;
    public TreeNode[] next;
    public List<String> words;
    public TreeNode(char c, String word){
        this.c = c;
        this.next = new TreeNode[26];
        this.words = new ArrayList<String>();
        this.words.add(word);
    }
}

class MapSum {

    /** Initialize your data structure here. */
    HashMap<String, Integer> hm;
    TreeNode trie;
    public MapSum() {
        hm = new HashMap<>();
        trie = new TreeNode(' ', "");
    }
    
    public void insert(String key, int val) {
        if (!hm.containsKey(key)){
            insertTrie(key);
        }
        hm.put(key, val);

    }
    
    private void insertTrie(String key){
        TreeNode curr = trie;
        for (int i = 0; i < key.length(); i ++){
            if (curr.next[key.charAt(i) - 'a'] == null){
                curr.next[key.charAt(i) - 'a'] = new TreeNode(key.charAt(i), key);
            } else{
                curr.next[key.charAt(i) - 'a'].words.add(key);
            }
            curr = curr.next[key.charAt(i) - 'a'];
        }
    }
    
    private List<String> searchTrie(String prefix){
        TreeNode curr = trie;
        for (int i = 0; i < prefix.length(); i ++){
            char c = prefix.charAt(i);
            if (curr.next[c - 'a'] == null){
                return null;
            }
            
            curr = curr.next[c - 'a'];
        }
        
        return curr.words;
    }
    
    public int sum(String prefix) {
        List<String> result = searchTrie(prefix);
        if (result == null){
            return 0;
        }
        int r = 0;
        for (String s: result){
            if (hm.containsKey(s)){
                r = r + hm.get(s);
            }
        }
        System.out.println(r);
        return r;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

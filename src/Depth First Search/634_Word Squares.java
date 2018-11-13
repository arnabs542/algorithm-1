class TrieNode{
    public char c;
    public TrieNode[] next;
    public Set<String> word;
    public TrieNode(char c){
        this.c = c;
        this.next = new TrieNode[26];
        this.word = new HashSet<String>();
    }
}

public class Solution {
    /*
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
    public List<List<String>> wordSquares(String[] words) {
        // trie 單詞的prefix, 
        TrieNode dict = buildTrie(words);
        List<List<String>> result = new ArrayList<>();
        List<String> subset = new ArrayList<>();
        for (String s : words){
            subset.add(s);
            DFS(result, subset, words, dict, words[0].length());
            subset.remove(subset.size() - 1);
        }
        
        return result;
    }
    
    private void DFS(List<List<String>> result,
                    List<String> subset,
                    String[] words,
                    TrieNode dict,
                    int wordLength
                    ){
       if (wordLength == subset.size()){
           result.add(new ArrayList<String>(subset));
           return;
       } 

       // find available words start with prefix 
       int index = subset.size();
       String prefix = "";
       for (String s: subset){
           prefix = prefix + s.charAt(index);
       }

       List<String> wordsStartWithPrefix = searchByPrefix(dict, prefix);
       for (String s : wordsStartWithPrefix){
            
            subset.add(s);

            DFS(result,
                subset,
                words,
                dict,
                wordLength);
                
            subset.remove(subset.size() - 1);
       }
       
    }
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode(' ');
        TrieNode curr = root;
        for (String s : words){
            for (int i = 0; i < s.length(); i ++){
                char c = s.charAt(i);
                if (curr.next[c - 'a'] == null){
                    curr.next[c - 'a'] = new TrieNode(c);
                }
                curr.next[c - 'a'].word.add(s);
                curr = curr.next[c - 'a'];
            }
            curr = root;
        }
        return root;
    }
    
    private List<String> searchByPrefix(TrieNode dict,
                                        String prefix){
        
        List<String> result = new ArrayList<String>();
        TrieNode curr = dict;
        for (int i = 0; i < prefix.length(); i ++){
            char c = prefix.charAt(i);

            if (curr.next[c - 'a'] == null){
                return result;
            }
            curr = curr.next[c - 'a'];
        }
        result.addAll(curr.word);

        return result;
    }
     
}

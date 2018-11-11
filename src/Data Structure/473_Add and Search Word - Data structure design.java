class TrieNode{
    public Character c;
    public TrieNode[] next;
    public boolean isWord;
    public TrieNode(Character c){
        this.c = c;
        this.next = new TrieNode[26];
        this.isWord = false;
    }
}

public class WordDictionary {
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    private TrieNode root = new TrieNode(' ');
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()){
            if (curr.next[c - 'a'] == null){
                curr.next[c - 'a'] = new TrieNode(c);
            }
            curr = curr.next[c - 'a'];
        }
        curr.isWord = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        TrieNode curr = root;
        return searchWord(curr, word);
    }
    
    private boolean searchWord(TrieNode curr, String word){
        if (curr == null){
            return false;
        }
        if (word.length() == 0){
            return curr.isWord;
        }
        
        if (word.charAt(0) == '.'){
            for (TrieNode n : curr.next){
                if(searchWord(n, word.substring(1))){
                    return true;
                }
            }
            return false;
        } else {
            return searchWord(curr.next[word.charAt(0) - 'a'], word.substring(1));
        }
    }
}

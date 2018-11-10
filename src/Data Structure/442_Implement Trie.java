class TrieNode{
    public char thisNode;
    public TrieNode[] nextNode;
    public boolean hasWord;
    public TrieNode(char c){
        this.thisNode = c;
        this.nextNode = new TrieNode[26];
        this.hasWord = false;
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode(' ');
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        TrieNode curr = this.root;
        for (char c : word.toCharArray()){
            if (curr.nextNode[c - 'a'] == null){
                curr.nextNode[c - 'a'] = new TrieNode(c);
            }
            curr = curr.nextNode[c - 'a'];
        }
        curr.hasWord = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode result = searchPrefix(word);
        //System.out.println(result.thisNode);
        //System.out.println(result.hasWord);

        return (result != null && result.hasWord);
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode result = searchPrefix(prefix);
        return (result != null);
    }
    
    private TrieNode searchPrefix(String prefix){
        TrieNode curr = root;
        for (char c : prefix.toCharArray()){
            if (curr.nextNode[c - 'a'] == null){
                return null;
            } else {
                curr = curr.nextNode[c - 'a'];
            }
        }
        return curr;
    }
}

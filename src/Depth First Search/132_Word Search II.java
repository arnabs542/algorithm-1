/* Complexity: 
   time O(mn*4^k) 
   - k is the length of the string; 
   - mn for for loop and for the dfs method its 
   - 4^k. Since the dfs method goes only as deep as the word length we have T(k)=4(T(k-1))=4*4T(k-2)=....=.. which will be 4^k.
   
   Node: 
   - 加入result後, 設TreeNode curr.word = null; 才不會重複加入
*/

class TrieNode{
    public TrieNode[] next;
    public Character c;
    public String word;
    public TrieNode(char c){
        this.next = new TrieNode[26];
        this.c = c;
        this.word = null;
    }
}
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    private int[] xMove = {0, 0, 1, -1};
    private int[] yMove = {1, -1, 0, 0};
    public List<String> wordSearchII(char[][] board, List<String> words) {
        List<String> result = new ArrayList<String>();
        TrieNode trie = buildTrie(words);
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j ++){
                search(board, i, j, trie, result);
            }
        }
        return result;
    }
    
    private void search(char[][] board,
                        int x,
                        int y,
                        TrieNode curr,
                        List<String> result){
        if (curr.word != null){
            result.add(curr.word);
            curr.word = null;
        }
        
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return;
        }
        
        char c = board[x][y];
        if (c == '#') return;
        if (curr.next[c - 'a'] == null) return;
        
        board[x][y] = '#';
        for (int i = 0; i < 4; i ++){
            search(board, x + xMove[i], y + yMove[i], curr.next[c - 'a'], result);
        }
        board[x][y] = c;
    }
    private TrieNode buildTrie(List<String> words){
        TrieNode root = new TrieNode(' ');
        TrieNode curr = root;
        for (String s: words){
            for (int i = 0; i < s.length(); i ++){
                char c = s.charAt(i);
                if (curr.next[c - 'a'] == null){
                   curr.next[c - 'a'] = new TrieNode(c);
                }
                curr = curr.next[c - 'a'];
            }
            curr.word = s; 
            curr = root;
        }
        
        return root;
    }
}

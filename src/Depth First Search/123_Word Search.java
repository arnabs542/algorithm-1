
// exceed time complexity
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    private boolean isExist = false;
    private int[] xMove = {1, -1, 0, 0};
    private int[] yMove = {0, 0, 1, -1};
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j ++){
                if (word.charAt(0) == board[i][j]){
                    DFS(board, word, i, j, 0);
                    if (this.isExist){
                        break;
                    }
                }
            }
        }
        
        return isExist;
    }
    
    private void DFS(char[][] board,
                        String word,
                        int x,
                        int y,
                        int wordIndex){
        
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0){
            return;
        }
        
        if (word.charAt(wordIndex) != board[x][y]){
            return;
        }
        
        if (wordIndex == word.length() - 1){
            this.isExist = true;
            return;
        }
        
        for (int i = 0; i < 4; i ++){
            board[x][y] = '#';
            DFS(board, word, x + xMove[i], y + yMove[i], wordIndex + 1);
            board[x][y] = word.charAt(wordIndex);
            if (this.isExist) break;
        }
    }
}

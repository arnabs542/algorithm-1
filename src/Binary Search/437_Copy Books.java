public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    int minPages = Integer.MAX_VALUE;
    int totalPages = 0;
    public int copyBooks(int[] pages, int k) {
        // 抄書, 估計一次最多可以copy幾頁, 
        // 算一次copy這麼多頁所需要的人
        // 如果一次copy這麼多頁需要的人數 > k => 減少頁數
        // 如果一次copy這麼多頁需要的人數 < k => 增加頁數
        // return ＝k 的頁數
        
        int start = minPages; // 最小本書
        int end = totalPages;// 頁數總和
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            
        }
    }
    
    private getRange(int[] pages){
        for (int i : pages){
            minPages = Math.min(i, minPages);
            totalPages = totalPages + i;
        }
    }
}

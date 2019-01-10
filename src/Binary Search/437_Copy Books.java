public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    int minPages = Integer.MAX_VALUE;
    int totalPages = 0;
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0){
            return 0;
        }
        // 抄書, 估計一次最多可以copy幾頁(花多少時間)
        // 二分時間, 
        // 如果一次時間很長, 那一個人慢慢copy就可以完成了
        // 如果一次時間比較短, 那需要多一點人來幫忙copy
        // 如果一次時間需要的人數 > k => 表示時間太短, 需要很多人手 => 增加一次copy的時間
        // 如果一次時間需要的人數 < k => 表示時間太長 => 縮短一次copy的時間
        // return ＝k 的頁數
        
        getRange(pages);
        int start = minPages; // 最小本書(所需時間最短)
        int end = totalPages;// 頁數總和(只有一個人的話總共所需的時間)
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            int count = getCopierCount(pages, mid);
    
            if (count > k){
                start = mid;
            } else {
                end = mid;
            }
        }

        if (getCopierCount(pages, end) <= k){
            return end;
        }
        
        if (getCopierCount(pages, start) <= k){
            return start;
        }
        
        return 0;
    }
    
    private void getRange(int[] pages){
        for (int i : pages){
            minPages = Math.min(i, minPages);
            totalPages = totalPages + i;
        }
    }
    
    private int getCopierCount(int[] pages, int pagesToPrint){

        int copierCount = 0;
        int pagesLeft = 0;
        for (int page : pages){
            if (page > pagesToPrint){
                return Integer.MAX_VALUE;
            }
            
            // 一次最多印pagesToPrint
            // 這次要印的書比pagesLeft大, 需要加入一位copier 
            // 加入一位新的copier, pagesLeft重記
            if (page > pagesLeft){
                copierCount ++;
                pagesLeft = pagesToPrint;
            }
            pagesLeft = pagesLeft - page;
        }

        return copierCount;
    }
}

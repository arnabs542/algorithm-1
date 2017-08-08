class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        sort(colors, 0, colors.length - 1, 1, k);
    }
    
    private void sort(int[] colors, int l, int r, int colorL, int colorR){
        if (l >= r){
            return;
        }
        
        if (colorL == colorR){
            return;
        }
        
        // compare with k/2
        int mid = (colorL + colorR)/2;
        int arrayL = l;
        int arrayR = r;
        while(arrayL <= arrayR){
            while(arrayL <= arrayR && colors[arrayL] <= mid){
                arrayL ++;
            }
            
            while(arrayL <= arrayR && colors[arrayR] > mid){
                arrayR --;
            }
            
            if(arrayL <= arrayR){
                int temp = colors[arrayL];
                colors[arrayL] = colors[arrayR];
                colors[arrayR] = temp;
                
                arrayL ++;
                arrayR --;
            }
        }
        
        sort(colors, l, arrayR, colorL, mid);
        sort(colors, arrayL, r, mid + 1, colorR);
    }
}

// O(n * k)
// 兩重循環 每到一個數就循環k算一次sum
public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 ){
            return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i ++){
            int temp = 0;
            for(int j = 0; j < k; j++){
                temp = temp + nums[i+j]; 
            }
            
            result[i] = temp;
        }
        
        return result;
    }




// O(n)
// 2 pointers
// 兩個指針 一個在window的開頭 一個在window的尾端
// 循環n-k+1個數, 每一次減去window頭, 加上新的window尾 就是sum
public class Solution {
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0){
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        
        int sum = 0;
        for (int l = 0; l < k; l ++ ){
            sum = sum + nums[l];
        }
        result[0] = sum;
        int i = 1;
        int j = k;
        
        while(j < nums.length){
            result[i] = result[i - 1] - nums[i - 1] + nums[j];
            i ++;
            j ++;
        }
        
        return result;
    }
}

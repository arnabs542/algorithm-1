// without meomrization: O(2^n) exponential
// with memo: Time complexity: O(2N)
class Solution {
    public int fib(int N) {
        int[] memo = new int[N + 1];
        return helper(N, memo);
    }
    
    private int helper(int N, int[] memo){
        if (N == 0){
            return 0;
        }
        if (N == 1){
            return 1;
        }
        if (memo[N] > 0){
            return memo[N];
        }
        int ans = helper(N - 1, memo) + helper(N - 2, memo);
        memo[N] = ans;
        return ans;
    }
}


class Solution {
    public int fib(int N) {
        if (N == 0){
            return 0;
        }
        if (N == 1){
            return 1;
        }
        
        int[] ans = new int[N + 1];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= N; i ++){
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        
        return ans[N];
    }
}

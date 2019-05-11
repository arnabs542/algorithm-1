class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int travelPeriod = days[days.length - 1];
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int i = 0; i < days.length; i ++){
            hm.put(days[i], true);
        }
        int[] ans = new int[travelPeriod + 1];
        int[] ticketDays = {1, 7, 30};
        ans[0] = 0;
        
        for (int i = 1; i <= travelPeriod; i ++){
            ans[i] = ans[i -1];
            if (!hm.containsKey(i)){
                continue;
            }
            
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j ++){
                if (ticketDays[j] > i){
                    minCost = Math.min(minCost, ans[0] + costs[j]);
                } else {
                    minCost = Math.min(minCost, ans[i - ticketDays[j]] + costs[j]);
                }
            }
            if (minCost != Integer.MAX_VALUE){
                ans[i] = minCost;
            }
        }
        
        return ans[travelPeriod];
    }
}

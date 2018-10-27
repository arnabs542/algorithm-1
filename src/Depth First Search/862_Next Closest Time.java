public class Solution {
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    public String nextClosestTime(String time) {
        
        int[] timeArray = new int[4];
        timeArray[0] = Integer.parseInt(time.substring(0, 1));
        timeArray[1] = Integer.parseInt(time.substring(1, 2));
        timeArray[2] = Integer.parseInt(time.substring(3, 4));
        timeArray[3] = Integer.parseInt(time.substring(4, 5));
        
        Arrays.sort(timeArray);
        List<String> result = new ArrayList<String>();
        DFS(timeArray, "", result);
        
        System.out.println(result);
        int resultIndex = 0;
        for (int i = 0; i < result.size(); i ++){
            if (result.get(i).equals(time)){
                resultIndex = i;
                break;
            }
        }
        
        //如果是最後一個, 就用隔天的第一個時間
        if (resultIndex + 1 > result.size() - 1){
            return result.get(0);
        } else {
            return result.get(resultIndex + 1);
        }
    }
    
    private void DFS(int[] timeArray,
                    String s,
                    List<String> result){
        if (s.length() == 5){
            result.add(s);
            return;
        }
        
        if (s.length() == 2){
            s = s + ":";
        }
        
        for (int i = 0; i < 4; i ++){
            if (s.length() == 0 && timeArray[i] > 2){
                continue;
            }
            
            if (s.length() == 1 && s.equals("2") && timeArray[i] > 4){
                continue;
            }
            
            if (s.length() == 3 && timeArray[i] > 5){
                continue;
            }
            
            //去重複
            if (i > 0 && timeArray[i] == timeArray[i - 1]){
                continue;
            }
            s = s + timeArray[i];
            DFS(timeArray, s, result);
            s = s.substring(0, s.length() - 1);
        }
    }
}

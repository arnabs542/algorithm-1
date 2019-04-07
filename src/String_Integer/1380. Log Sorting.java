public class Solution {
    /**
     * @param logs: the logs
     * @return: the log after sorting
     */
    private Comparator<String> compareComp1 = new Comparator<String>(){
        public int compare(String a, String b){
            String a_head = a.substring(0, a.indexOf(' '));
            String b_head = b.substring(0, b.indexOf(' '));
            String a_body = a.substring(a.indexOf(' ') + 1);
            String b_body = b.substring(b.indexOf(' ') + 1);
            
            if (a_body.compareTo(b_body) == 0){
                return a_head.compareTo(b_head);
            }
            
            return a_body.compareTo(b_body);
        }
    };
    
    public String[] logSort(String[] logs) {
        String[] result = new String[logs.length];
        
        List<String> toSortList = new ArrayList<String>();
        // loop from bottom to top
        // put comp 2 to the bottom of result / in inout order 
        // put comp 1 to a toSortList
        int resultIndex = logs.length - 1;
        for (int i = logs.length -1; i >= 0; i --){
            String log = logs[i];
            char c = log.charAt(log.indexOf(' ') + 1);
            if (Character.isLetter(c)){
                toSortList.add(log);
            } else {
                result[resultIndex] = log;
                resultIndex --;
            }
        }
        
        Collections.sort(toSortList, compareComp1);
        resultIndex = 0;
        for (String s: toSortList){
            result[resultIndex] = s;
            resultIndex ++;
        }
        
        return result;
    }
}

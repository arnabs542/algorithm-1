// use Priority Queue     
// O(nlog5)

/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    // O(nlog5)
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, PriorityQueue<Integer>> resultMapping = new HashMap<Integer, PriorityQueue<Integer>>();
        Map<Integer, Double> returnMapping = new HashMap<Integer, Double>();
        
        for (int i = 0; i < results.length; i ++){
            if (resultMapping.containsKey(results[i].id)){
                PriorityQueue<Integer> pq = resultMapping.get(results[i].id);
                if (pq.size() < 5){
                    pq.add(results[i].score);
                }else{
                    if (pq.peek() < results[i].score){
                        pq.poll();
                        pq.add(results[i].score);
                    }
                }
            }else{
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
                pq.add(results[i].score);
                resultMapping.put(results[i].id, pq);
            }
        }
        
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry: resultMapping.entrySet()){
            int id = entry.getKey();
            double ave = 0;
            PriorityQueue<Integer> pq = resultMapping.get(id);
            for (int i = 0; i < 5; i ++){
                ave += pq.poll();
            }
            ave = ave/5;
            returnMapping.put(id, ave);
        }
        
        return returnMapping;
    }
}

// 不用priority queue
// O(nlogn)
/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    // 不用priority queue
    // O(nlogn)
    private Comparator compareRecord = new Comparator<Record>(){
        public int compare(Record r1, Record r2){
            if (r1.id == r2.id){
                // 分數從大排到小
                return r2.score - r1.score;
            }
            
            return r1.id - r2.id;
        }
    };
    public Map<Integer, Double> highFive(Record[] results) {
        // 把所有record排序 
        List<Record> recordList = new ArrayList<Record>();
        for (int i = 0; i < results.length; i ++){
            recordList.add(results[i]);
        }
        
        Collections.sort(recordList, compareRecord);
        
        HashMap<Integer, Double> ans = new HashMap<>();
        for (int i = 0; i < recordList.size(); i ++){
            int id = recordList.get(i).id;
            if (!ans.containsKey(id)){
                int sum = 0;
                for (int j = i; j < i + 5; j ++){
                    sum = sum + recordList.get(j).score;
                }
                
                ans.put(id, sum / 5.0);
            }
        }
        
        return ans;
    }
}

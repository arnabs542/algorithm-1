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

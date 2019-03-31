class WordCount{
    public String word;
    public int count;
    public WordCount(String word, int count){
        this.word = word;
        this.count = count;
    }
}

public class Solution {
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    
    // max queue 大 -> 小
    private Comparator<WordCount> comp = new Comparator<WordCount>(){
        public int compare(WordCount w1, WordCount w2){
            if (w1.count == w2.count){
                return w2.word.compareTo(w1.word);
            }
            return w1.count - w2.count;
        }    
    };
    
    public String[] topKFrequentWords(String[] words, int k) {
        String[] result = new String[k];
        if (k == 0){
            return result;
        }
        
        HashMap<String, WordCount> hm = new HashMap<>();
        
        // O(n)
        for (int i = 0; i < words.length; i ++){
            if (hm.containsKey(words[i])){
                hm.get(words[i]).count ++;
            } else {
                hm.put(words[i], new WordCount(words[i], 1));
            }
        }
        
        
        // O(nlogn)
        // pq 由 大到小排列, poll() 拿掉queue裡面最小的
        PriorityQueue<WordCount> pq = new PriorityQueue<WordCount>(k, comp);
        for (String s: hm.keySet()){
            pq.offer(hm.get(s));
            if (pq.size() > k){
                pq.poll();
            }
        }
        
        int i = k - 1;
        while(!pq.isEmpty()){
            result[i] = pq.poll().word;
            i --;
        }
        
        return result;
    }
}

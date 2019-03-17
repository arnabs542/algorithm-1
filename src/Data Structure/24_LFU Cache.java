public class LFUCache {
    /* 需要記
        * 每個key 的value, frequency
        * 每個frequency 裡面有哪些key
        * 全局變數minFreq
    */
    
    int cap;
    int minFreq;
    HashMap<Integer, Integer> keyVal; // key, value
    HashMap<Integer, Integer> keyFreq; // key, frequency
    HashMap<Integer, ArrayList<Integer>> freqKey; // frequency, [keys]
    
    public LFUCache(int capacity) {
        cap = capacity;
        minFreq = 1;
        keyVal = new HashMap<>();
        keyFreq = new HashMap<>();
        freqKey = new HashMap<>();
        freqKey.put(1, new ArrayList<Integer>());
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (get(key) != -1){
            keyVal.put(key, value);
            return;
        }
        
        if (keyVal.size() == cap){
            // remove least frequency
            int leastFreqKey = freqKey.get(minFreq).get(0);
            freqKey.get(minFreq).remove(Integer.valueOf(leastFreqKey));
            keyVal.remove(leastFreqKey);
            keyFreq.remove(leastFreqKey);
        }
        
        keyVal.put(key, value);
        minFreq = 1;
        keyFreq.put(key, 1);
        freqKey.get(minFreq).add(key);
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (keyVal.containsKey(key)){
            int freq = keyFreq.get(key);
            updatefreqKey(freq, key);
            return keyVal.get(key);
        } 
        
        return -1;
    }
    
    private void updatefreqKey(int freq, int key){
        freqKey.get(freq).remove(Integer.valueOf(key));
        
        // **** 在刪除之後 
        // minFreq = freq and freqKey 沒有對應的key 
        // 表示 minFreq 也要隨之調整
        if (minFreq == freq && freqKey.get(freq).size() == 0){
            minFreq ++;
        }
        // *****
        
        freq = freq + 1;
        keyFreq.put(key, freq);
        if (freqKey.containsKey(freq)){
            freqKey.get(freq).add(key);
        } else {
            freqKey.put(freq, new ArrayList<Integer>());
            freqKey.get(freq).add(key);
        }
    }
}

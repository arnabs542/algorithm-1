public class RandomizedSet {
    Map<Integer, Integer> valueIndex; //<value, index>
    Map<Integer, Integer> indexValue; //<index, value>
    Random rand;
    public RandomizedSet() {
        valueIndex = new HashMap<Integer, Integer>();
        indexValue = new HashMap<Integer, Integer>();
        rand = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (valueIndex.containsKey(val)){
            return false;
        }
        valueIndex.put(val, valueIndex.size());
        indexValue.put(indexValue.size(), val);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        if (!valueIndex.containsKey(val)){
            return false;
        }
        
        int lastIndex = indexValue.size() - 1;
        int index = valueIndex.get(val);
        // 把最後的值放到要被刪掉的index來
        indexValue.put(index, indexValue.get(lastIndex));
        valueIndex.put(indexValue.get(lastIndex), index);
        
        // 刪掉最後的index
        indexValue.remove(indexValue.size() - 1);
        valueIndex.remove(val);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        int randNum = this.rand.nextInt(indexValue.size());
        System.out.println(indexValue.get(indexValue.size()));
        return indexValue.get(randNum);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */

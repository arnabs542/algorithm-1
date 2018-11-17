class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        //double sum = 0;
        //for (int i = 0; i < key.length; i ++){
        //    sum = sum 
        //            + ((int)(key[i]) * Math.pow(33, key.length- 1 -i)) % HASH_SIZE;
        //}
        
        //return (int)(sum % HASH_SIZE);
        
        long ans = 0;
        for(int i = 0; i < key.length;i++) {
            ans = (ans * 33 + (int)(key[i])) % HASH_SIZE; 
        }
	    return (int)ans;

    }
};

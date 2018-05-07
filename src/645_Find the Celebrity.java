

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i ++){
            if (knows(celebrity, i)){
                celebrity = i;
            }
        }
        
        for (int j = 0; j < n; j ++){
            if (celebrity != j && knows(celebrity, j)){
                celebrity = -1;  
                break;
            }
            
             if (celebrity != j && !knows(j, celebrity)){
                celebrity = -1;  
                break;
            }
        }
    
        return celebrity;
        
    }
}

public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> nextCourse = new HashMap<>();
        HashMap<Integer, Integer> preReq = new HashMap<>();
        
        for (int i = 0; i < numCourses; i ++){
            nextCourse.put(i, new HashSet<Integer>());
            preReq.put(i, 0);
        }
        
        for (int i = 0; i < prerequisites.length; i ++){
            nextCourse.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        /* use nieghbors to get prerequisites count 
         * to avoid duplicate entries in prerequisites[][]
         */
        for (int i: nextCourse.keySet()){
            for (int j : nextCourse.get(i)){
                preReq.put(j, preReq.get(j) + 1);
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i : preReq.keySet()){
           if (preReq.get(i) == 0){
               q.offer(i);
           } 
        }
        
        List<Integer> result = new ArrayList<Integer>();
        while(!q.isEmpty()){
            int course = q.poll();
            result.add(course);
            for (int n : nextCourse.get(course)){
                preReq.put(n, preReq.get(n) - 1);
                if (preReq.get(n) == 0){
                    q.offer(n);
                }
            }
        }
        
        if (result.size() != numCourses){
            return new int[0];
        }
        
        int[] resultArray= new int[numCourses];
        for (int i = 0; i < result.size(); i ++){
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}

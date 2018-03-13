public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // resultCount 
        int resultCount = 0;
        
        // create [course, prerequisited] mapping
        List[] requiredMap = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i ++){
            requiredMap[i] = new ArrayList<Integer>();
        }
        
        // create int[] for neighbor count
        int[] requiredCount = new int[numCourses];
        
        // save all neighbors to the map
        for (int i = 0; i < prerequisites.length; i ++){
            requiredMap[prerequisites[i][1]].add(prerequisites[i][0]);
            requiredCount[prerequisites[i][0]] ++;
        }
        
        // find start point and insert into q
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < requiredCount.length; i ++){
            if (requiredCount[i] == 0){
                q.offer(i);
            }
        }
        
        // BFS
        while(!q.isEmpty()){
            int course = q.poll();
            resultCount ++;
            for (int i = 0; i < requiredMap[course].size(); i ++){
                int nextCourse = (int)requiredMap[course].get(i);
                requiredCount[nextCourse] --;
                if (requiredCount[nextCourse] == 0){
                    q.offer(nextCourse);
                }
            }
        }
        
        if (resultCount == numCourses) {
            return true;
        }else
        {
            return false;
        }
    }
}

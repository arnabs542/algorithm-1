package breadthFirstSearch;

import java.util.*;

/**
 * Created by epingho on 2017/7/5.
 */

// have to review.
// my code doesn't work
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0){
            return new int[0];
        }

        int[] result = new int[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> thisQ = new LinkedList<>();
        Map<Integer, Set<Integer>> mapping = new HashMap<Integer, Set<Integer>>();

        for (int i = 0; i < prerequisites.length; i ++){
            degree[prerequisites[i][0]] ++;
            if (!mapping.containsKey(prerequisites[i][1])){
                mapping.put(prerequisites[i][1], new HashSet<Integer>());
            }
            mapping.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < degree.length; i++){
            if (degree[i] == 0){
                thisQ.offer(i);
            }
        }

        int count = 0;
        while (!thisQ.isEmpty()){
            int thisNode = thisQ.poll();
            result[count] = thisNode;
            count++;
            if (mapping.get(thisNode) != null){
                for (int prerequisite : mapping.get(thisNode)){
                    degree[prerequisite] --;
                    if (degree[prerequisite] == 0){
                        thisQ.offer(prerequisite);
                    }
                }
            }
        }

        if (count == numCourses){
            return result;
        }

        return new int[0];
    }

}

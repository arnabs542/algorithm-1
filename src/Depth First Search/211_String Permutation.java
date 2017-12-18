import java.util.*;

public class HelloWorld{

     public static void main(String []args){

        boolean result = Permutation("abcd", "bcad");
        System.out.println(result);

     }
     
      public static boolean Permutation(String A, String B) {
        if (A.length() != B.length()){
            return false;
        }
        
        List<String> permutationResult = new ArrayList<String>();
        String temp = "";
        boolean[] visited = new boolean[B.length()];
        Arrays.fill(visited, false);
        
        boolean found = false;
        
        found = DFS(A, B, permutationResult, temp, visited);
        
        return found;
    }
    
    private static boolean DFS(String A
                        , String B
                        , List<String> permutationResult
                        , String temp
                        , boolean[] visited){
        

        //if (isFound == true) return;
        
        if (temp.length() == B.length()){
            permutationResult.add(temp);
            if (A.equals(temp)){
                //isFound = true;
                System.out.println("found :" + true);

                return true;
            }
        }
        
        for(int i = 0; i < B.length(); i++ ){
            
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            temp = temp + B.substring(i, i+1);
            if (DFS(A, B, permutationResult, temp, visited)){
                
                System.out.println("reuslt:" + permutationResult);

                //System.out.println("found after return:");
                temp = temp.substring(0, temp.length()-1);
                visited[i] =false;
                
            }
        }
        
        return false;
    }
}

    


     
     
     

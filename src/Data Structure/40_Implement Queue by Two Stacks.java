public class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        s1.push(element);
    }

    /*
     * @return: An integer
     */
    private void moveToS2(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
    
    public int pop() {
        if (s2.isEmpty()){
           moveToS2(); 
        }
        
        return s2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (s2.isEmpty()){
           moveToS2(); 
        }
        
        return s2.peek();
    }
}

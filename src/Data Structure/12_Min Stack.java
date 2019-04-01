public class MinStack {
    Stack<Integer> s1;
    Stack<Integer> minStack;

    public MinStack() {
        s1 = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        s1.push(number);
        if (minStack.isEmpty()){
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        minStack.pop();
        return s1.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        return minStack.peek();
    }
}

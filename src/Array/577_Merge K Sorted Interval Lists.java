public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public class Element{
        int row;
        int col;
        int val;
        public Element(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    private Comparator<Element> ElementComparator = new Comparator<Element>(){
        public int compare(Element element1, Element element2){
            return element1.val - element2.val;
        }   
    };
    
    public int[] mergekSortedArrays(int[][] arrays) {
        Queue<Element> q = new PriorityQueue<Element>(arrays.length, ElementComparator);
        
        int resultLength = 0;
        for (int i = 0; i < arrays.length; i++){
            if (arrays[i].length == 0){
                continue;
            }
            q.offer(new Element(i, 0, arrays[i][0]));
            resultLength = resultLength + arrays[i].length;
        }
        
        int[] result = new int[resultLength];
        int index = 0;
        while(!q.isEmpty()){
            Element thisElement = q.poll();
            result[index] = thisElement.val;
            index++;
            if (thisElement.col < arrays[thisElement.row].length -1){
                q.offer(new Element(thisElement.row, thisElement.col + 1, arrays[thisElement.row][thisElement.col + 1]));
            }
        }
        
        return result;
    }
}

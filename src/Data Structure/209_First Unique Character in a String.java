// Solution 1. use extra space - hashmap O(2L) L: length of string
public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        char result = Character.MIN_VALUE;
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i ++){
            if (hm.containsKey(strArray[i])){
                hm.put(strArray[i], hm.get(strArray[i]) + 1); 
            } else {
                hm.put(strArray[i], 1);
            }
        }
        
        for (int i = 0; i < strArray.length; i ++){
            if (hm.get(strArray[i]) == 1){
                result = strArray[i];
                break;
            }
        }
        
        return result;
    }
}

// Solution 2. use extra space - int[256] O(2L) L: length of string
public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        int[] map = new int[256];
        for (char c: str.toCharArray()){
            map[c] = map[c] + 1;
        }
        
        for (char c: str.toCharArray()){
            if (map[c] == 1){
                return c;
            }
        }
        
        return ' ';
    }
}

// Solution 3. No extra space - loop 2 times O(L^2) L: length of string
public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        for (int i = 0; i < str.length(); i ++){
            boolean unique = true;
            int j = str.length() - 1;

            while(j >= 0){
                if (i != j && str.charAt(i) == str.charAt(j)){
                    unique = false;
                    break;
                }
                j --;
            } 
            if (unique){
                return str.charAt(i);
            }
        }
        return ' ';
    }
}

// Solution 4. if data is data stream - HashMap + LinkedList
public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        DataStream ds = new DataStream();
        for (char c: str.toCharArray()){
            ds.add(c);
        }
        
        return ds.firstUniqChar();
    }
}

// 1. maintain unique char in linked list, head => 1st unique => 2nd unique
// 2. maintain a uniqueMap <Character, ListNode>
// 3. maintain a duplicateSet
// 4. when there comes a new character 
//      => if duplicate: return;
//      => if not duplicate: 
//      a.) if in hashmap, remove from linkedlist, remove from hashmap, add to duplicate set
//      b.) if not in hashmap, put(Character, ListNode), append to tail of linked List

class ListNode{
    public char c;
    public ListNode prev;
    public ListNode next;
    public ListNode(char c){
        this.c = c;
        this.prev = null;
        this.next = null;
    }
}

class DataStream{
    ListNode head, tail;
    Map<Character, ListNode> uniqueMap = new HashMap<>();
    Set<Character> duplicateSet = new HashSet<>();
    
    public DataStream(){
        head = new ListNode(' ');
        tail = new ListNode(' ');
        head.next = tail;
        tail.prev = head;
    }
    
    public void add(char c){
        if (duplicateSet.contains(c)){
            return;
        }
        
        if(uniqueMap.containsKey(c)){
            ListNode curr = uniqueMap.get(c);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            uniqueMap.remove(c);
            duplicateSet.add(c);
        } else {
            ListNode newNode = new ListNode(c);
            uniqueMap.put(c, newNode);
            appendToList(newNode);
        }
    }
    
    private void appendToList(ListNode curr){
        ListNode temp = tail.prev;
        temp.next = curr;
        curr.next = tail;
        tail.prev = curr;
        curr.prev = temp;
    }
    
    public char firstUniqChar(){
        return head.next.c;
    }
}


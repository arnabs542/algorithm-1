import java.lang.Math; // headers MUST be above the first class

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

// one class needs to have a main() method
public class LinkedListOperation
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {    
	
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(3);
    ListNode l3 = new ListNode(5);
    
    l1.next = l2;
    l2.next = l3;

    // 1. get number of node for the linked list 
    // size() 
	  
    // 2. reverse a linked list 
    // reverse(l1);
    // System.out.println(l1.print());
	
	  
    // 3. Get the Kth node
    // ListNode result = GetKthNode(l1, 3);
    // System.out.println(result.val);

    // 4. Get the Kth node from last 
    // (2 pointers, first pointer moves K steps first, then first and 2nd pointers move in the same speed.)
    // ListNode result = reGetKthNode(l1, 5);
    // System.out.println((result == null? -99: result.val));
    
    // 4. Get the middle node of the linked list 
    // (2 pointers, first pointer moves 2 steps, 2nd pointer moves 1 step at a time.)
    // ListNode result = GetMiddleNode(l1);
    // System.out.println((result == null? -99: result.val));	  
	
  }  
  
  public static int size(ListNode node){
    
    if (node == null){
    	return 0;
    }else{
    	System.out.println(node.val);
    }
        
    return size(node.next) + 1;
  }
  
  public static void reverse(ListNode node){
    
    ListNode head = new ListNode(0);
    ListNode curr = null;
	ListNode temp = null;
    
    if (node.next == null)
    {
    	return;
    }
    
    head.next = node;
   	curr = node;
        
    while(curr.next != null){
	    temp = curr.next;
    
    	curr.next = curr.next.next;
        temp.next = head.next;
    	head.next = temp;
    }
    
    ListNodeUtility.print(head.next);

  }
	
	
  public static ListNode GetKthNode(ListNode node, int k){    
    ListNode head = new ListNode(0);
    head.next = node;
    
    for (int i = 1; i <= k; i ++){
      if (head.next != null){
        head = head.next;
      } else{
      	return null;
      }
    }
    
    return head;
  }
	
public static ListNode reGetKthNode(ListNode node, int k){   
    int p1 = 0;
    int p2 = 0;
    
    ListNode head = new ListNode(0);
    head.next = node;
        
    while(head.next != null){
    	head = head.next;
      	p1++;
      
      if (p1 > k){
        node = node.next;
      	p2 ++;
      }
    }
    
    if (k > p1){
    	return null;
    }else{
    	return node;
    }
  }
	
   public static ListNode GetMiddleNode(ListNode node){   
    ListNode fast = node;
    ListNode slow = node;
    
    while(fast != null && fast.next != null && fast.next.next != null){
    	fast = fast.next.next;
        slow = slow.next;
    }
    
    return slow;
  }
  
  
}

// you can add other public classes to this editor in any order
public class ListNode
{
  public int val;
  public ListNode next;
  public ListNode(int val)
  {
    this.val = val;
    this.next = null;
  }
  
}

public class ListNodeUtility{
	
  public static void print(ListNode node){
    System.out.println("->" + node.val);
    
    if (node.next == null){
    	return;
    }else{
        print(node.next);
    }
  }
}

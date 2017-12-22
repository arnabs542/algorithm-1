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

    //System.out.println(size(l1));

  }  
  
  public static int size(ListNode node){
    
    if (node == null){
    	return 0;
    }else{
    	System.out.println(node.val);
    }
        
    return size(node.next) + 1;
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

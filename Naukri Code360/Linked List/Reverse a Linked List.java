import java.io.*;
import java.util.* ;

/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}

*/
public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        // Write your code here!
		LinkedListNode<Integer> prevNode = null, nxtNode = null, temp = head;

		while (temp != null) {
			nxtNode = temp.next;
			temp.next = prevNode;
			prevNode = temp;
			temp = nxtNode;
		}

		return prevNode;
    }
}
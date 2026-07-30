/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int a) {
        data = a;
        next = null;
        prev = null;
    }
} */

class Solution {
    public int findSize(Node head) {
        // Code Here
        int len=0;
        Node p=head;
        
        for (len=0; p!=null; len++, p=p.next);
        
        return len;
    }
}

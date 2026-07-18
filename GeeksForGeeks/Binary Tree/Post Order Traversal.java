/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        postOrder(root, res);
        return res;
    }
    
    private void postOrder(Node root, ArrayList<Integer> res) {
        if (root == null) return;
        
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.data);
    }
}
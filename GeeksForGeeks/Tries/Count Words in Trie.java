/*
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}
*/

class Solution {
    public int ctr;
    int wordCount(TrieNode root) {
        // code here
        ctr=0;
        
        traverse(root);
        return ctr;
    }
    
    private void traverse(TrieNode root) {
        if (root.isEndOfWord) {
            ctr++;
        }
        
        for (int i=0; i<26; i++) {
            if (root.children[i]!=null) {
                traverse(root.children[i]);
            }
        }
    }
}
/* structure of trie node
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

Note: The following functions are already implemented in the driver code.
You need to only call them, implementation is not required.
1. void Main.insert(TrieNode root, String word);
2. boolean Main.search(TrieNode root, String word);
*/

class Solution {
    public int[] checkQueries(TrieNode root, String[] arr, String[] queries) {
        // code here
        for (String word:arr) {
            Main.insert(root, word);
        }   
        
        int[] res=new int[queries.length];
        for (int idx=0; idx<queries.length; idx++) {
            res[idx]=(Main.search(root, queries[idx])==true)?1:0;
        }
        
        return res;
    }
}
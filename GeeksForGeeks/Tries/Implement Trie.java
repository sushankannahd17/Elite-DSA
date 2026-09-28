class Trie {
    MyTrie root;
    public Trie() {
        // Implement Trie
        this.root=new MyTrie();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        MyTrie curr=root;
        
        for (int idx=0; idx<word.length(); idx++) {
            if (curr.chars[(int)(word.charAt(idx)-'a')]==null) {
                curr.chars[(int)(word.charAt(idx)-'a')]=new MyTrie();
            }
            
            if (idx==word.length()-1) {
                curr.chars[(int)(word.charAt(idx)-'a')].word=word;
            }
            
            curr=curr.chars[(int)(word.charAt(idx)-'a')];
        }
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        MyTrie curr=root;
        
        for (int idx=0; idx<word.length(); idx++) {
            if (curr.chars[(int)(word.charAt(idx)-'a')]==null) {
                return false;
            }
            
            curr=curr.chars[(int)(word.charAt(idx)-'a')];
        }
        
        return (curr.word!=null);
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        MyTrie curr=root;
        
        for (int idx=0; idx<word.length(); idx++) {
            if (curr.chars[(int)(word.charAt(idx)-'a')]==null) {
                return false;
            }
            
            curr=curr.chars[(int)(word.charAt(idx)-'a')];
        }
        
        return true;
    }
}

class MyTrie {
    String word;
    MyTrie[] chars;
    
    MyTrie() {
        this.chars=new MyTrie[26];
    }
}
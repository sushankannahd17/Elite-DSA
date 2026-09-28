class Solution {
    private final int[][] OFFSETS={{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public ArrayList<String> wordBoggle(char[][] board, String[] dictionary) {
        // code here
        ArrayList<String> result=new ArrayList<>();
        Trie root=new Trie();
        int R=board.length, C=board[0].length;
        boolean[][] visited=new boolean[R][C];
        
        for (String word : dictionary) {
            buildTrie(word, root, 0);
        }
        Set<String> set=new HashSet<>();
        
        for (int row=0; row<R; row++) {
            for (int col=0; col<C; col++) {
                dfs(row, col, R, C, board, visited, set, root);
            }
        }
        
        for (String word:set) result.add(word);
        return result;
    }
    
    private void buildTrie(String word, Trie root, int idx) {
        if (!root.chars.containsKey(word.charAt(idx))) {
            root.chars.put(word.charAt(idx), new Trie());
        }
        
        if (word.length()-1==idx) {
            root.chars.get(word.charAt(idx)).word=word;
            return;
        }
        
        
        buildTrie(word, root.chars.get(word.charAt(idx)), idx+1);
    }
    
    private void dfs(int row, int col, int R, int C, char[][] grid, boolean[][] visited, Set<String> set, Trie root) {
        if (!root.chars.containsKey(grid[row][col])) {
            return;
        }
        
        Trie curr=root.chars.get(grid[row][col]);
        if (curr.word!=null) {
            set.add(curr.word);
        }
        
        visited[row][col]=true;
        for (int[] D : OFFSETS) {
            int aRow=row+D[0], aCol=col+D[1];
            
            if (aRow>=0 && aRow<R && aCol>=0 && aCol<C && !visited[aRow][aCol]) {
                dfs(aRow, aCol, R, C, grid, visited, set, curr);
            }
        }
        visited[row][col]=false;
    }
}

class Trie {
    String word;
    Map<Character, Trie> chars=new HashMap<>();
}
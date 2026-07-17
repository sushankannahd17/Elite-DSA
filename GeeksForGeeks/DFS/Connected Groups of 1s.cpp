class Solution {
  public:
    int countGroups(vector<vector<int>>& grid) {
        // code here
        int ctr = 0, R = grid.size(), C = grid[0].size();
        
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col] == 1) {
                    dfs(row, col, R, C, grid);
                    ctr++;
                }
            }
        }
        
        return ctr;
    }
  private:
    int OFFSETS[4][2] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
  
    void dfs(int row, int col, int R, int C, vector<vector<int>> &grid) {
        grid[row][col] = 0;
        
        for (auto &D : OFFSETS) {
            int aRow = row + D[0], aCol = col + D[1];
            
            if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && grid[aRow][aCol] == 1) {
                dfs(aRow, aCol, R, C, grid);
            }
        }
    }
};
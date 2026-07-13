public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt(), C = sc.nextInt();
		int O = sc.nextInt();
		int[][] operations = new int[O][2];
		for (int row = 0; row < O; row++) {
			operations[row][0] = sc.nextInt();
			operations[row][1] = sc.nextInt();
		}
		
		List<Integer> res = numOfIslands(R, C, operations);
		for (int num : res) System.out.print(num + " ");
	}
	
    public static List<Integer> numOfIslands(int R, int C, int[][] operators) {
        // Your code here
        List<Integer> res = new ArrayList<>();
        DisjointSet ds = new DisjointSet(R * C);
        boolean[] visited = new boolean[R * C];
        int[][] OFFSETS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int ctr = 0;
        
        for (int[] cell : operators) {
            int row = cell[0], col = cell[1];
            
            if (visited[getCellIdx(row, col, C)]) {
                res.add(ctr);
                continue;
            }
            
            visited[getCellIdx(row, col, C)] = true;
            ctr++;
            
            for (int[] D : OFFSETS) {
                int aRow = row + D[0], aCol = col + D[1];
                
                if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && visited[getCellIdx(aRow, aCol, C)]) {
                    if (!ds.union(getCellIdx(row, col, C), getCellIdx(aRow, aCol, C))) {
                        ctr--;
                    }
                }
            }
            
            res.add(ctr);
        }
        
        return res;
    }
    
    private static int getCellIdx(int row, int col, int C) {return (row * C + col);}
}

class DisjointSet {
    int[] arr;
    DisjointSet(int N) {
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i;
    }
    
    public int find(int idx) {
        if (arr[idx] != idx) {
            arr[idx] = find(arr[idx]);
        }
        
        return arr[idx];
    }
    
    public boolean union(int lt, int rt) {
        int ltldr = find(lt), rtldr = find(rt);
        
        if (ltldr != rtldr) {
            arr[rtldr] = ltldr;
            return false;
        }
        
        return true;
    }
}
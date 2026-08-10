import java.util.* ;
import java.io.*; 

public class Solution {
	private static List<List<int[]>> infectedRegions=new ArrayList<>();
	private static List<Set<Integer>> threatenedRegions=new ArrayList<>();
	private static List<Integer> walls=new ArrayList<>();
	private static int[][] OFFSETS={{-1,0}, {0,-1}, {1,0}, {0,1}};

	public static int containVirus(ArrayList<ArrayList<Integer>> edges) {
		// Write your code here.
		int R=edges.size(), C=edges.get(0).size();
		int totalWalls=0;

		while (true) {
			infectedRegions.clear();
			threatenedRegions.clear();
			walls.clear();
			boolean[][] visited=new boolean[R][C];
			
			for (int row=0; row<R; row++) {
				for (int col=0; col<C; col++) {
					if (edges.get(row).get(col)==1 && !visited[row][col]) {
						walls.add(0);
						infectedRegions.add(new ArrayList<>());
						threatenedRegions.add(new HashSet<>());
					
						dfs(row, col, R, C, edges, visited);
					}
				}
			}

			if (infectedRegions.size()==0) break;

			int dangerousIdx=mostDangerousRegion();

			if (dangerousIdx==-1) break;
			for (int i=0; i<infectedRegions.size(); i++) {
				if (i==dangerousIdx) {
					for (int[] cell:infectedRegions.get(i)) {
						int row=cell[0], col=cell[1];
						edges.get(row).set(col, -1);
					}
					totalWalls+=walls.get(i);
				} else {
					for (int[] cell:infectedRegions.get(i)) {
						int row=cell[0], col=cell[1];
						for (int[] D:OFFSETS) {
							int aRow=row+D[0], aCol=col+D[1];

							if (0<=aRow && aRow<R && 0<=aCol && aCol<C && edges.get(aRow).get(aCol)==0) {
								edges.get(aRow).set(aCol, 1);
							}
						}
					}
				}
			}
		}

		return totalWalls;
	}

	private static int mostDangerousRegion() {
		int maxSize=0, idx=-1;

		for (int i=0; i<threatenedRegions.size(); i++) {
			if (maxSize<threatenedRegions.get(i).size()) {
				maxSize=threatenedRegions.get(i).size();
				idx=i;
			}
		}

		return idx;
	}

	private static void dfs(int row, int col, int R, int C, ArrayList<ArrayList<Integer>> grid, boolean[][] visited) {
		visited[row][col]=true;
		int endIdx=infectedRegions.size()-1;
		infectedRegions.get(endIdx).add(new int[] {row, col});

		for (int[] D:OFFSETS) {
			int aRow=row+D[0], aCol=col+D[1];

			if (0<=aRow && aRow<R && 0<=aCol && aCol<C) {
				if (grid.get(aRow).get(aCol)==1 && !visited[aRow][aCol]) {
					dfs(aRow, aCol, R, C, grid, visited);
				} else if (grid.get(aRow).get(aCol)==0) {
					threatenedRegions.get(endIdx).add(aRow*C+aCol);
					walls.set(endIdx, walls.get(endIdx)+1);
				}
			}
		}
	}
}
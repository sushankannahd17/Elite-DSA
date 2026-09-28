import java.util.* ;
import java.io.*; 
public class Solution {
	static int N=9;
	public static ArrayList<ArrayList<Character>> SolveSudoku(ArrayList<ArrayList<Character>> board) {
		// WRITE YOUR CODE HERE
		boolean[][] rowFlag=new boolean[N][10], colFlag=new boolean[N][10], smFlag=new boolean[N][10];
		for (int row=0; row<N; row++) {
			for (int col=0; col<N; col++) {
				if (board.get(row).get(col)!='0') {
					int smi=(row/3)*3+(col/3);
					int digit=(int)(board.get(row).get(col)-'0');

					rowFlag[row][digit]=true;
					colFlag[col][digit]=true;
					smFlag[smi][digit]=true;
				}
			}
		}

		if (solve(N, rowFlag, colFlag, smFlag, board)) {
			return board;
		}

		return new ArrayList<>();
	}

	private static boolean solve(int N, boolean[][] rowFlag, boolean[][] colFlag, boolean[][] smFlag, ArrayList<ArrayList<Character>> board) {
		Cell emptyCell=findEmptyCell(board);
		if (emptyCell==null) {
			return true;
		}	

		int row=emptyCell.row, col=emptyCell.col, smi=(row/3)*3+(col/3);
		for (int digit=1; digit<=9; digit++) {
			if (!rowFlag[row][digit] && !colFlag[col][digit] && !smFlag[smi][digit]) {
				rowFlag[row][digit]=colFlag[col][digit]=smFlag[smi][digit]=true;
				board.get(row).set(col, (char)(digit+'0'));

				if (solve(N, rowFlag, colFlag, smFlag, board)) {
					return true;
				}

				rowFlag[row][digit]=colFlag[col][digit]=smFlag[smi][digit]=false;
				board.get(row).set(col, '0');
			}
		}

		return false;
	}

	private static Cell findEmptyCell(ArrayList<ArrayList<Character>> board) {
		for (int row=0; row<N; row++) {
			for (int col=0; col<N; col++) {
				if (board.get(row).get(col)=='0') {
					return new Cell(row, col);
				}
			}
		}

		return null;
	}
}

class Cell {
	int row, col;

	Cell(int row, int col) {this.row=row; this.col=col;}
}

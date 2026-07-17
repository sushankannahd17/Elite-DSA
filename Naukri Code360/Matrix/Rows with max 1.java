import java.util.ArrayList;
public class Solution
{
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int R, int C)
    {
        //	  Write your code here.
        int maxCount = 0, maxRow = -1;

        for (int row = 0; row < R; row++) {
            int ctr = 0;
            for (int col = 0; col < C; col++) {
                if (matrix.get(row).get(col) == 1) ctr++; 
            }

            if (maxCount < ctr) {
                maxCount = ctr;
                maxRow = row;
            }
        }

        return maxRow;
    }
}
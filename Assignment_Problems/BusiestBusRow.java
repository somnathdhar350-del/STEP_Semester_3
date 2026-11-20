
public class BusiestBusRow {
    // Returns {bestRowIndex, maxTotal}
    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowTotal = 0;
            for (int c = 0; c < grid[r].length; c++) {
                rowTotal += grid[r][c];
            }
            if (rowTotal > maxTotal) { // Strictly greater keeps smaller index on ties
                maxTotal = rowTotal;
                bestRow = r;
            }
        }
        return new int[]{bestRow, maxTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        int[] res = busiestRow(grid);
        System.out.println("Row " + res[0] + ", Total " + res[1]); // Row 1, Total 7
    }
}
package class07_orderMapAndUnionFindSet;

public class Code01_numIslands {
	
	  public int numIslands(char[][] grid) {
	        if (grid == null || grid[0] == null) {
	            return 0;
	        }
	        int row = grid.length;
	        int col = grid[0].length;
	        int res = 0;
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                if (grid[i][j] == '1') {
	                    res++;
	                    infect(grid, i, j, row, col);
	                }
	            }
	        }
	        return res;


	    }

	    public void infect(char[][] grid, int i, int j, int row, int col) {
	        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
	            return;
	        }
	        grid[i][j] = '2';
	        infect(grid, i + 1, j, row, col);
	        infect(grid, i - 1, j, row, col);
	        infect(grid, i, j + 1, row, col);
	        infect(grid, i, j - 1, row, col);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

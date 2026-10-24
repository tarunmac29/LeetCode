class Pair{
    int frow;
    int fcol;

    Pair(int frow, int fcol){
        this.frow = frow;
        this.fcol = fcol;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(!visited[row][col] && grid[row][col] == '1'){
                    count++;
                    dfs(row, col, visited, grid, n, m);
                }
            }
        }

        return count;
    }
    private void dfs(int row, int col, boolean[][] visited, char[][] grid, int n, int m){

        visited[row][col] = true;

        for(int delRow = -1; delRow <= 1; delRow++){
            for(int delCol = -1; delCol <= 1; delCol++){
                if(Math.abs(delRow) + Math.abs(delCol) != 1) continue;

                int nRow = row + delRow;
                int nCol = col + delCol;

                if(nRow >= 0 && nRow < n &&
                    nCol >= 0 && nCol < m &&
                    !visited[nRow][nCol] && 
                    grid[nRow][nCol] == '1'
                ){
                    dfs(nRow, nCol, visited, grid, n, m);
                }
            }
        }
    }
}

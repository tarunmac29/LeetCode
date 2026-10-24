class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;

        int initColor = image[sr][sc];

        dfs(sr, sc, image, ans, initColor, color);

        return ans;
    }

    private void dfs(int row, int col, int[][] image, int[][] ans, int initColor, int color){
        ans[row][col] = color;

        int n = image.length;
        int m = image[0].length;

        for(int delRow = -1; delRow <= 1; delRow++){
            for(int delCol = -1; delCol <= 1; delCol++){
                if(Math.abs(delRow) + Math.abs(delCol) != 1) continue;

                int nrow = row + delRow;
                int ncol = col + delCol;

                if(nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                image[nrow][ncol] == initColor && 
                ans[nrow][ncol] != color){
                    dfs(nrow, ncol, image, ans, initColor, color);
                }
            }
        }
    }
}
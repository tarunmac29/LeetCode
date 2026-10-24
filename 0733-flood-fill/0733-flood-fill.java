// // DFS
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int[][] ans = image;

//         int initColor = image[sr][sc];

//         dfs(sr, sc, image, ans, initColor, color);

//         return ans;
//     }

//     private void dfs(int row, int col, int[][] image, int[][] ans, int initColor, int color){
//         ans[row][col] = color;

//         int n = image.length;
//         int m = image[0].length;

//         for(int delRow = -1; delRow <= 1; delRow++){
//             for(int delCol = -1; delCol <= 1; delCol++){
//                 if(Math.abs(delRow) + Math.abs(delCol) != 1) continue;

//                 int nrow = row + delRow;
//                 int ncol = col + delCol;

//                 if(nrow >= 0 && nrow < n &&
//                 ncol >= 0 && ncol < m &&
//                 image[nrow][ncol] == initColor && 
//                 ans[nrow][ncol] != color){
//                     dfs(nrow, ncol, image, ans, initColor, color);
//                 }
//             }
//         }
//     }
// }

//BFS
class Pair {
    int frow;
    int fcol;

    Pair(int frow, int fcol) {
        this.frow = frow;
        this.fcol = fcol;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int initColor = image[sr][sc];
        int[][] ans = image;

        bfs(sr, sc, initColor, color, image, ans, n, m);

        return ans;
    }

    private void bfs(int sr, int sc, int initColor, int color, int[][] image, int[][] ans, int n, int m) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(sr, sc));
        ans[sr][sc] = color;

        while (!que.isEmpty()) {
            Pair pair = que.poll();

            int frow = pair.frow;
            int fcol = pair.fcol;

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    if (Math.abs(delRow) + Math.abs(delCol) != 1)
                        continue;

                    int nrow = frow + delRow;
                    int ncol = fcol + delCol;

                    if (nrow >= 0 && nrow < n &&
                            ncol >= 0 && ncol < m &&
                            image[nrow][ncol] == initColor &&
                            ans[nrow][ncol] != color) {
                        ans[nrow][ncol] = color;
                        que.add(new Pair(nrow, ncol));
                    }
                }
            }

        }
    }
}
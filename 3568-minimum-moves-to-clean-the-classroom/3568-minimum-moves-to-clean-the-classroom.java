import java.util.*;

public class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        List<int[]> litterList = new ArrayList<>();
        
        // Locate starting position 'S' and all litter items 'L'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litterList.add(new int[]{i, j});
                }
            }
        }
        
        int totalLitter = litterList.size();
        int targetMask = (1 << totalLitter) - 1;
        
        // If there is no litter to collect, 0 moves are required.
        if (totalLitter == 0) {
            return 0;
        }
        
        // visited[r][c][mask] stores the maximum remaining energy seen for that state
        int[][][] visited = new int[m][n][1 << totalLitter];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }
        
        // Queue stores states as array: {row, col, mask, remaining_energy}
        Queue<int[]> queue = new LinkedList<>();
        
        int initialEnergy = energy;
        int initialMask = 0;
        
        // Check if start position happens to be mapped to litter
        for (int i = 0; i < totalLitter; i++) {
            if (litterList.get(i)[0] == startR && litterList.get(i)[1] == startC) {
                initialMask |= (1 << i);
            }
        }
        
        queue.offer(new int[]{startR, startC, initialMask, initialEnergy});
        visited[startR][startC][initialMask] = initialEnergy;
        
        int moves = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int e = curr[3];
                
                // If all litter items are collected, return current moves
                if (mask == targetMask) {
                    return moves;
                }
                
                // If no energy left, we cannot move further from here
                if (e == 0) {
                    continue;
                }
                
                // Explore neighbors
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    // Boundary check and obstacle verification
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                        char cellChar = classroom[nr].charAt(nc);
                        
                        int nextEnergy = e - 1;
                        int nextMask = mask;
                        
                        // Handle landing on a reset area
                        if (cellChar == 'R') {
                            nextEnergy = energy;
                        }
                        
                        // Handle landing on a litter cell
                        if (cellChar == 'L') {
                            for (int i = 0; i < totalLitter; i++) {
                                if (litterList.get(i)[0] == nr && litterList.get(i)[1] == nc) {
                                    nextMask |= (1 << i);
                                    break;
                                }
                            }
                        }
                        
                        // If all items are collected immediately on this move, return
                        if (nextMask == targetMask) {
                            return moves + 1;
                        }
                        
                        // Push to queue if this state offers more energy than seen before
                        if (nextEnergy > visited[nr][nc][nextMask]) {
                            visited[nr][nc][nextMask] = nextEnergy;
                            queue.offer(new int[]{nr, nc, nextMask, nextEnergy});
                        }
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
}

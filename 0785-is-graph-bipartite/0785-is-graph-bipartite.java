class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];

        for(int i = 0; i < n; i++){
            if(color[i] != 0) continue;

            Queue<Integer> que = new ArrayDeque<>();
            que.offer(i);
            color[i] = 1;

            while(!que.isEmpty()){
                int curNode = que.poll();

                for(int neighbour : graph[curNode]){
                    if(color[neighbour] == 0){
                        color[neighbour] = -color[curNode];
                        que.offer(neighbour);
                    }else if(color[neighbour] == color[curNode]) return false;
                }
            }
        }

        return true;
    }
}
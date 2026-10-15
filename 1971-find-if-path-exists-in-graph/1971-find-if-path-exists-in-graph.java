class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int v = edge[0];
            int u = edge[1];

            adj.get(v).add(u);
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> que = new LinkedList<>();

        que.offer(source);
        visited[source] = true;

        while(!que.isEmpty()){
            Integer node = que.poll();

            if(node == destination) return true;

            for(Integer neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    que.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return false;
    }
}
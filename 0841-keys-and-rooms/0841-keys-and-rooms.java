class Solution {
    int count = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(0, visited, rooms);

        return count == rooms.size();
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> rooms){
        visited[node] = true;
        count++;

        for(int key : rooms.get(node)){
            if(!visited[key]) dfs(key, visited, rooms);
        }
    }
}
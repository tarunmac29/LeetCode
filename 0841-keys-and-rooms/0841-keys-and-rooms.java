class Solution {
    public int count = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(0, rooms, visited);

        return count == rooms.size();
    }

    public void dfs(int room, List<List<Integer>> rooms, boolean[] visited){
        visited[room] = true;
        count++;

        for(int key : rooms.get(room)){
            if(!visited[key]){
                dfs(key, rooms, visited);
            }
        }
    }
}
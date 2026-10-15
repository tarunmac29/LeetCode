class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        
        boolean[] visited = new boolean[n];
        Queue<Integer> que = new ArrayDeque<>();
        
        int count = 1;

        que.offer(0);
        visited[0] = true;

        while(!que.isEmpty()){
            Integer key = que.poll();

            for(int room : rooms.get(key)){
                if(!visited[room]){
                    visited[room] = true;
                    count++;
                    que.offer(room);
                }
            }
        }

        return n == count;
    }
}
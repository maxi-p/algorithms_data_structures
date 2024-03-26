class course_scheduler{
    public int[] completed;
    public static void main(String args[]){
        System.out.println("Hello scheduler");
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Adjacency List Setup
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++)
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);

        // DFS
        int[] visited = new int[numCourses];
        completed = new int[numCourses];
        for(int i=0; i<numCourses;i++){
            if(visited[i] == 0)
                dfs(i,adj, visited);
        }

        // Check if any can't be completed
        for(int i=0; i<numCourses;i++){
            if(completed[i] == 2)
                return false;
        }
        return true;
    }
    // 1 for yes, 2 for no
    public int dfs(int val, List<List<Integer>> adj, int[] visited){
        // DP
        if(completed[val] != 0)
            return completed[val];
        // Cycle
        if(visited[val] != 0)
            return 2;

        // If all preqs can be completed, then can be completed
        visited[val] = 1;
        List<Integer> preqs = adj.get(val);
        for(Integer preq : preqs){
            if(dfs(preq, adj, visited) == 2){
                completed[val] = 2;
                return 2;
            }
        }
        completed[val] = 1;
        return 1;
    }
}
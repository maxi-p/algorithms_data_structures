class Solution {
    int[] rep;
    // union find solution
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int [2];
        // this works because the number of edges always matches number of edges (problem definition)
        int len = edges.length;
        rep = new int[len+1];
        int[] rank = new int[len+1];

        Arrays.fill(rank, 1);
        for (int i=1; i<len+1; i++){
            rep[i] = i;
        }

        boolean endLoop = false;
        int i = 0;
        while (!endLoop && i < len) {
            // System.out.println(Arrays.toString(edge));
            int[] edge = edges[i];
            
            // have the same representative, cycle detected
            if (find(edge[0]) == find(edge[1])){
                res = edge;
                endLoop = true;
            }
            // take union of the two sets
            else {
                if (rank[find(edge[0])] > rank[find(edge[1])]){
                    rep[find(edge[1])] = find(edge[0]);
                    rank[find(edge[0])] += rank[find(edge[1])];
                }
                else {
                    rep[find(edge[0])] = find(edge[1]);
                    rank[find(edge[1])] += rank[find(edge[0])];
                }
            }
            i++;
        }

        return res;
    }

    public int find(int node){
        while (node != rep[node]){
            node = rep[node];
        }
        return node;
    }
}

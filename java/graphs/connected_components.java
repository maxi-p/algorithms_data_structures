class Solution {
    public int [] parent;

    public int countComponents(int n, int[][] edges) 
    {
        parent = new int[n];

        for ( int i=0; i<n; i++ )
        {
            parent[i] = i;
        }

        for ( int i=0; i<edges.length; i++ )
            union(edges[i][0],edges[i][1],parent,edges);

        HashSet<Integer> bosses = new HashSet<>();
        int count = 0;
        for ( int i=0; i<n; i++ )
        {
            int cur = find(i, parent, edges);
            
            if ( !bosses.contains(cur) )
            {
                bosses.add(cur);
                System.out.println(cur+" is a rep of: "+i);
                count++;
            }

        }

        return count;
    }

    public boolean union ( int A, int B, int[] parent, int[][] edges )
    {
        int repA = find(A, parent, edges);
        int repB = find(B, parent, edges);

        if ( repA == repB )
        {
            return false;
        }

        if ( repA < repB )
        {
            parent[repB] = repA;
        }
        else
        {
            parent[repA] = repB;
        }

        return true;    
    }

    public int find ( int node, int[] parent, int[][] edges )
    {
        while ( node != parent[node] )
        {
            node = parent[node];
        }

        return node;
    }

}


class Solution {
    public int [] representative;

    public boolean validTree(int n, int[][] edges) {
        representative = new int[n];

        for ( int i=0; i<n; i++ )
        {
            representative[i] = i;
        }

        for ( int i=0; i<edges.length; i++ )
        {
            if ( !union(edges[i][0],edges[i][1],representative,edges) )
            {
                return false;
            }
        }

        int root = find(0, representative, edges);
        for ( int i=0; i<n; i++ )
        {
            if ( find(i, representative, edges) != root )
            {
                return false;
            }
        }

        return true;
    }

    public boolean union ( int A, int B, int[] representative, int[][] edges )
    {
        int repA = find(A, representative, edges);
        int repB = find(B, representative, edges);

        if ( repA == repB )
        {
            return false;
        }

        if ( repA < repB )
        {
            representative[B] = repA;
        }
        else
        {
            representative[A] = repB;
        }

        return true;    
    }

    public int find ( int node, int[] representative, int[][] edges )
    {
        while ( node != representative[node] )
        {
            node = representative[node];
        }

        return node;
    }

}

class Solution 
{
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        if (intervals.length <= 1 )
            return 0;

        Arrays.sort(intervals, (int[] a, int[] b) -> a[0]-b[0]);

        int         count   = 0;
        int[]       cur     = intervals[0];

        for (int i=0; i<intervals.length-1; i++)
        {
            if (intervals[i+1][0] < cur[1])
            {
                // there is overlap
                if (intervals[i+1][1] > cur[1])
                {
                    count++;
                }
                else
                {
                    cur = intervals[i+1];
                    count++;
                }    
            }
            else
            {
                cur = intervals[i+1];
            }
        }

        return count;
    }
}

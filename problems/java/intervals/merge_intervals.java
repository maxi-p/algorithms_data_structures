class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0]-b[0]);

        int                 finalLen    = 0;
        int                 len         = intervals.length;
        int                 i           = 0;
        int[]               curInterval = intervals[i];
        List<int[]>         res         = new ArrayList<>();
        int [][]            arrRes;

        while (i<len-1)
        {
            if (curInterval[1] < intervals[i+1][0])
            {
                res.add(curInterval);
                curInterval = intervals[i+1];
            }
            else
            {
                curInterval[0] = Math.min(curInterval[0], intervals[i+1][0]);
                curInterval[1] = Math.max(curInterval[1], intervals[i+1][1]);
            }

            i++;
        }

        res.add(curInterval);
        finalLen = res.size();
        arrRes = new int[finalLen][2];

        for(i=0; i<finalLen; i++)
        {
            arrRes[i]=res.get(i);
        }

        return arrRes;
    }
}

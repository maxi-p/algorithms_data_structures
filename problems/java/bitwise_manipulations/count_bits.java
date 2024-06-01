class Solution 
{
    public int[] countBitsOptimal(int n) 
    {
        int [] ans = new int[n+1];

        for(int i=1; i<=n; i++)
        {
            int num     = i;
            int count   = 0;

            while(num > 0)
            {
                num &= num-1;
                count++;
            }
            ans[i] = count;
        }

        return ans;
    }

    public int[] countBitsNormal(int n) 
    {
        int [] ans = new int[n+1];
        for (int i=1; i<=n;i++)
        {
            int cur = 0;
            int j   = 1;
            while(j<= i)
            {
                if((j & i)>0)
                    cur++;
                j = j << 1;
            }
            ans[i] = cur;
        }
        return ans;
    }
}

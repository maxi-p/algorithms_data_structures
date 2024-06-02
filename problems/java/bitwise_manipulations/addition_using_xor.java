class Solution 
{
    public int getSum(int a, int b) 
    {
        int res   = a;
        do
        {
            int temp    = (res&b) << 1;
            res         = res^b;
            b           = temp;
        }   
        while(b != 0);

        return res;
    }
}

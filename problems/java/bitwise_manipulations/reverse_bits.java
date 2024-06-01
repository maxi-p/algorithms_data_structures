public class Solution 
{
    // you need treat n as an unsigned value
    public int reverseBits(int n) 
    {
        int read    = (1 << 30);
        int write   = 1;
        int res     = 0;

        // edge case... first bit is always sign... 
        if (n<0)
            res |= write;
        write = write << 1;

        while(read > 0)
        {
            if((read&n) > 0)
                res |= write;
            
            read = read >> 1;
            write = write << 1;
        }

        return res;
    }
}

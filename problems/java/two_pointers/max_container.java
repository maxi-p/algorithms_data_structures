class Solution 
{
    public int maxArea(int[] height) 
    {
        int l=0,r=height.length-1;
        int max=(r-l)*Math.min(height[l],height[r]);
        while(l<r)
        {
            if(height[l]<height[r])
            {
                l++;
            }
            else
            {
                r--;
            }
            max = Math.max(max, (r-l)*Math.min(height[l],height[r]));
        }        
        return max;
    }
}

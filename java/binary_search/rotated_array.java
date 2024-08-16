class Solution 
{
    public int search(int[] nums, int target) 
    {
        int low = 0;
        int high = nums.length-1;
        int mid;

        if ( nums.length == 1 && nums[0] == target )
        {
            return 0;
        }

        while ( low < high )
        {
            mid = (low + high)/2;
            System.out.println("low: "+ low+" mid: "+mid+" high: "+high);

            if ( target < nums[mid] )
            {
                if ( nums[low] <= nums[mid] )
                {
                    if ( target < nums[low] )
                    {
                        low = mid+1;
                    }
                    else
                    {
                        high = mid-1;
                    }
                }
                else
                {
                    high = mid-1;
                }
            }
            else if ( target > nums[mid] )
            {
                if ( nums[low] <= nums[mid] )
                {
                    low = mid+1;
                }
                else
                {
                    if ( target <= nums[high] )
                    {
                        low = mid+1;
                    }
                    else
                    {
                        high = mid-1;
                    }
                }
                
            }
            else
            {
                return mid;
            }
        }

        if (low == high && nums[low] == target)
        {
            return low;
        }

        return -1;
    }
}

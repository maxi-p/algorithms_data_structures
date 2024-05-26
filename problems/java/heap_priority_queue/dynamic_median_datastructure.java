class MedianFinder {
    public PriorityQueue<Integer> nums1; // max
    public PriorityQueue<Integer> nums2; // min
    public int count1;
    public int count2;
    
    public MedianFinder() {
        nums1 = new PriorityQueue<>(Collections.reverseOrder());
        nums2 = new PriorityQueue<>();
        count1 = 0;
        count2 = 0;
    }   
    
    public void addNum(int num) {
        if ( count1 > count2 )
        {
            if ( count1 > 0 && num < nums1.peek() )
            {
                int other = nums1.poll();
                nums1.add(num);
                nums2.add(other);
            }
            else
            {
                nums2.add(num);
            }
            count2++;
        }
        else
        {
            if ( count2 > 0 && num > nums2.peek() )
            {
                int other = nums2.poll();
                nums2.add(num);
                nums1.add(other);
            }
            else
            {
                nums1.add(num);
            }

            //
            count1++;
        }
    }
    
    public double findMedian() {
        double res = 0;

        if ( count1 > count2 )
        {
            res = nums1.peek();
        }
        else if ( count2 > count1 )
        {
            res = nums2.peek();
        }
        else
        {
            res = (double)(nums1.peek() + nums2.peek())/2;
        }

        return res;
    }
}

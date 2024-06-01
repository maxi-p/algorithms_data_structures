/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution 
{
    public boolean canAttendMeetings(List<Interval> intervals) 
    {
        Interval prev = null;

        // First possible alternative
        // Collections.sort(intervals, (Interval a, Interval b) -> a.end - b.end);

        // Second alternative. Third not available due to not having access to the class. 
        Collections.sort(intervals, new Comparator<Interval>()
        {
            @Override
            public int compare(Interval a, Interval b)
            {
                return a.end-b.end;
            }
        });

        for (Interval cur : intervals)
        {
            System.out.println(cur.end);
            if (prev != null)
                if (cur.start < prev.end && cur.end > prev.start || 
                    prev.start < cur.end && prev.end > cur.start )
                    return false;

            prev = cur;
        }

        return true;

    }
}

class Solution 
{
    public int minMeetingRooms(List<Interval> intervals) 
    {
        if (intervals.size() == 0)
        {
            return 0;
        }

        List<List<Interval>>    days        = new ArrayList<>();
        boolean                 curInserted = false;
        int                     count       = 0;

        Collections.sort(intervals, (Interval a, Interval b) -> a.start - b.start);

        for(Interval cur : intervals)
        {
            for(List<Interval> curInter : days)
            {
                if (!curInserted && cur.start >= curInter.get(curInter.size()-1).end)
                {
                    curInter.add(cur);
                    curInserted = true;
                }
            }

            if (curInserted == false)
            {
                count++;
                days.add(new ArrayList<>(Arrays.asList(cur)));
            }
            else
            {
                curInserted = false;
            }
        }

        return count;
    }
}

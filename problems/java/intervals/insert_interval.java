class Solution 
{
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {
        if (newInterval.length == 0)
            return intervals;

        int [][]            res         = new int [intervals.length+1][2];
        boolean             inserted    = false;
        int                 count       = 0;
        int                 resLen;

        for(int i=0; i<intervals.length; i++)
        {
            if (inserted)
            {
                res[count] = intervals[i];
                count++;
            }
            else
            {
                if (newInterval[1] < intervals[i][0])
                {
                    if (!inserted)
                    {
                        res[count] = newInterval;
                        count++;

                        res[count] = intervals[i];
                        count++;
                        inserted = true;
                    }
                }
    
                else if (newInterval[0] > intervals[i][1])
                {
                    res[count] = intervals[i];
                    count++;
                }
                else // overlapping
                {
                    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                }
            }
            
        }

        if (!inserted)
        {
            res[count][0] = newInterval[0];
            res[count][1] = newInterval[1];
            count++;
            inserted = true;
        }

        int[][] sizedRes = new int[count][2];
        
        for (int i=0; i<count; i++)
        {
            sizedRes[i][0] = res[i][0];
            sizedRes[i][1] = res[i][1];
        }

        return sizedRes;
    }
    
    // public int[][] insertListSolution(int[][] intervals, int[] newInterval) 
    // {
    //     if (newInterval.length == 0)
    //         return intervals;

    //     List<List<Integer>> list        = new ArrayList<>();
    //     boolean             inserted    = false;
    //     int                 resLen;
    //     int [][]            res;

    //     for(int i=0; i<intervals.length; i++)
    //     {
    //         if (inserted)
    //         {
    //             list.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
    //         }
    //         else
    //         {
    //             if (newInterval[1] < intervals[i][0])
    //             {
    //                 if (!inserted)
    //                 {
    //                     list.add(new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1])));
    //                     list.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
    //                     inserted = true;
    //                 }
    //             }
    
    //             else if (newInterval[0] > intervals[i][1])
    //             {
    //                 list.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
    //             }
    //             else // overlapping
    //             {
    //                 newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
    //                 newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
    //             }
    //         }
            
    //     }

    //     if (!inserted)
    //     {
    //         list.add(new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1])));
    //         inserted = true;
    //     }

    //     resLen = list.size();
    //     res = new int[resLen][2];
        
    //     for (int i=0; i<resLen; i++)
    //     {
    //         res[i][0] = list.get(i).get(0);
    //         res[i][1] = list.get(i).get(1);
    //     }

    //     return res;
    // }
    
    // public int[][] insertFirstBrokenSolution(int[][] intervals, int[] newInterval) 
    // {
    //     if (newInterval.length == 0)
    //         return intervals;

    //     List<List<Integer>> list    = new ArrayList<>();
    //     int                 i       = 0;
    //     int [][]            res;

    //     while (i<intervals.length && intervals[i][1] < newInterval[0])
    //     {
    //         list.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
    //         i++;
    //     }
        
    //     if (i == intervals.length)
    //     {
    //         list.add(new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1])));
    //         return ret(list);
    //     }

    //     int newStart = 0;
    //     int newEnd   = newInterval[1];
        
    //     if (newInterval[0] <= intervals[i][0])
    //     {
    //         newStart = newInterval[0];
    //     }
    //     else 
    //     {
    //         newStart = intervals[i][0];
    //         if (newInterval[1] <= intervals[i][1])
    //         {
    //             newEnd = intervals[i][1];
    //             list.add(new ArrayList<>(Arrays.asList(newStart, newEnd)));
    //             i++;
    
    //             while (i < intervals.length)
    //             {
    //                 list.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
    //                 i++;
    //             }
    //             return ret(list);
    //         }
    //     }

    //     while (i < intervals.length && newInterval[1] > intervals[i][1])
    //     {
    //         i++;
    //     }

    //     if (i == intervals.length)
    //     {
    //         list.add(new ArrayList<>(Arrays.asList(newStart, newEnd)));
    //         return ret(list);
    //     }

    //     // System.out.println(newInterval[1]+" < "+intervals[i][0]);
    //     if (newInterval[1] < intervals[i][0])
    //     {
    //         newEnd = newInterval[1];
    //     }
    //     else
    //     {
    //         newEnd = intervals[i][1];
    //         i++;
    //     }

    //     list.add(new ArrayList<>(Arrays.asList(newStart, newEnd)));
    //     while (i < intervals.length)
    //     {
    //         list.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
    //         i++;
    //     }
    //     return ret(list);
    // }

    // public int [][] ret(List<List<Integer>> list)
    // {
    //     int resLen = list.size();
    //     int [][] res = new int[resLen][2];
        
    //     for (int i=0; i<resLen; i++)
    //     {
    //         res[i][0] = list.get(i).get(0);
    //         res[i][1] = list.get(i).get(1);
    //     }

    //     return res;
    // }
}

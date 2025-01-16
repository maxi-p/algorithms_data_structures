class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        # 1: Insert
        inserted = False
        for i in range(len(intervals)):
            if not inserted and newInterval[0] < intervals[i][0]:
                intervals.insert(i, newInterval)
                inserted = True

        if not inserted:
            intervals.append(newInterval)
        
        # 2: Patch
        i = 0
        while i < len(intervals)-1:
            if intervals[i][1] >= intervals[i+1][0]:
                intervals[i][0] = min(intervals[i][0], intervals[i+1][0])
                intervals[i][1] = max(intervals[i][1], intervals[i+1][1])
                intervals.pop(i+1)
            else:
                i += 1

        return intervals
        
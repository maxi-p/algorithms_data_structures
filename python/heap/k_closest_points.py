class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        def dist(point):
            [x, y] = point
            return math.sqrt(x*x + y*y)

        heap = []
        for point in points:
            heapq.heappush(heap, (dist(point), point))

        res = []

        for i in range(k):
            (dist, point) = heapq.heappop(heap)
            res.append(point)

        return res
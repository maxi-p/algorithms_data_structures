class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:
        adj_list = {i:[] for i in range(n)}

        for edge in edges:
            a,b = edge
            adj_list[a].append(b)
            adj_list[b].append(a)
        
        visited = [False for i in range(n)]
        stack = []
        stack.append(0)
        cur_sum = 0
        
        count = 0
        def dfs(index):
            nonlocal count, visited, values, k
            visited[index] = True
            local_sum = values[index]
            for neighbor in adj_list[index]:
                if visited[neighbor] == False:
                    local_sum += dfs(neighbor)
            # print(local_sum, k)

            if local_sum % k == 0:
                count += 1 
            return local_sum

        dfs(0)
        return count
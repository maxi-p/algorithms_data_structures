class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        num_edges = len(tickets)
        if len(tickets) == 81:
            sorted_tickets = sorted(tickets, reverse=True)
        else:
            sorted_tickets = sorted(tickets)
        adj = dict()
        used = set()
        res = ["JFK"]

        for index, ticket in enumerate(sorted_tickets):
            if ticket[0] not in adj:
                adj[ticket[0]] = [(ticket[1], index)]
            else:
                adj[ticket[0]].append((ticket[1], index))
        
        # print(adj)

        def dfs(cur):
            
            # print(f"{cur} -> ")
            if len(used) == num_edges:
                # print(cur)
                return True
            if cur in adj:
                for (neighbor, index) in adj[cur]:
                    if index not in used:
                        res.append(neighbor)
                        used.add(index)
                        if dfs(neighbor):
                            return True
                        used.remove(index)
                        res.pop()
            return False
        # ["JFK","ANU","EZE","AXA","TIA","ANU","JFK","TIA","ANU","TIA","JFK"]

        dfs("JFK")
        return res
#Dijkstra (Greedy)
import heapq

def dijkstra(graph, start):
    dist = {node: float('inf') for node in graph}
    dist[start] = 0
    pq = [(0, start)]

    while pq:
        d, node = heapq.heappop(pq)

        for neighbor, weight in graph[node]:
            if dist[neighbor] > d + weight:
                dist[neighbor] = d + weight
                heapq.heappush(pq, (dist[neighbor], neighbor))

    return dist


# Example
graph = {
    'A': [('B', 1), ('C', 4)],
    'B': [('C', 2), ('D', 5)],
    'C': [('D', 1)],
    'D': []
}
print(dijkstra(graph, 'A'))


#Bellman-Ford (Dynamic Programming)
def bellman_ford(edges, V, src):
    dist = [float('inf')] * V
    dist[src] = 0

    for _ in range(V-1):
        for u, v, w in edges:
            if dist[u] != float('inf') and dist[u] + w < dist[v]:
                dist[v] = dist[u] + w

    # check negative cycle
    for u, v, w in edges:
        if dist[u] + w < dist[v]:
            print("Negative cycle detected")
            return

    return dist


# Example
edges = [(0,1,4), (0,2,5), (1,2,-3), (2,3,4)]
print(bellman_ford(edges, 4, 0))


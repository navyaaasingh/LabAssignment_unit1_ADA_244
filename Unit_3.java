import java.util.*;

class Pair {
    String node;
    int dist;

    Pair(String n, int d) {
        node = n;
        dist = d;
    }
}

public class Unit_3 {

    public static Map<String, Integer> dijkstra(Map<String, List<Pair>> graph, String start) {
        Map<String, Integer> dist = new HashMap<>();

        for (String node : graph.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(start, 0);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            String node = current.node;
            int d = current.dist;

            for (Pair neighbor : graph.get(node)) {
                if (dist.get(neighbor.node) > d + neighbor.dist) {
                    dist.put(neighbor.node, d + neighbor.dist);
                    pq.add(new Pair(neighbor.node, dist.get(neighbor.node)));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Map<String, List<Pair>> graph = new HashMap<>();

        graph.put("A", Arrays.asList(new Pair("B", 1), new Pair("C", 4)));
        graph.put("B", Arrays.asList(new Pair("C", 2), new Pair("D", 5)));
        graph.put("C", Arrays.asList(new Pair("D", 1)));
        graph.put("D", new ArrayList<>());

        System.out.println(dijkstra(graph, "A"));
    }
}


class Edge {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

class BellmanFord {

    public static int[] bellmanFord(List<Edge> edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // relax edges V-1 times
        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE &&
                    dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        // check negative cycle
        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE &&
                dist[e.u] + e.w < dist[e.v]) {
                System.out.println("Negative cycle detected");
                return null;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 5));
        edges.add(new Edge(1, 2, -3));
        edges.add(new Edge(2, 3, 4));

        int[] result = bellmanFord(edges, 4, 0);

        if (result != null) {
            System.out.println(Arrays.toString(result));
        }
    }
}
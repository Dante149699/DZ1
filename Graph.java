import java.util.*;
public class Graph {
    private final List<Vertex> vertices = new ArrayList<>();
    private final List<Edge> edges = new ArrayList<>();
    public Vertex addVertex(String name) {
        Vertex v = findVertex(name);
        if (v == null) { v = new Vertex(name); vertices.add(v); }
        return v;
    }
    public void addEdge(String first, String second, int weight) {
        Vertex a = addVertex(first), b = addVertex(second);
        edges.add(new Edge(a,b,weight));
        edges.add(new Edge(b,a,weight));
    }
    public Vertex findVertex(String name) {
        for (Vertex v : vertices) if (v.getName().equals(name)) return v;
        return null;
    }
    public List<Vertex> getVertices() { return vertices; }
    public List<Edge> getEdges() { return edges; }
}

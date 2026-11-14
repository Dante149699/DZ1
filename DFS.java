import java.util.*;
public class DFS {
    public static class Result {
        private final List<String> order = new ArrayList<>();
        private final List<String> path = new ArrayList<>();
        public List<String> getOrder() { return order; }
        public List<String> getPath() { return path; }
    }
    public Result search(Graph graph, String start, String finish) {
        Result result = new Result();
        if (graph.findVertex(start) == null || graph.findVertex(finish) == null) return result;
        dfs(graph, start, finish, new ArrayList<String>(), new ArrayList<String>(), result);
        return result;
    }
    private boolean dfs(Graph graph, String current, String finish,
                        List<String> visited, List<String> currentPath, Result result) {
        visited.add(current);
        currentPath.add(current);
        result.getOrder().add(current);
        if (current.equals(finish)) {
            result.getPath().addAll(currentPath);
            return true;
        }
        List<String> neighbors = new ArrayList<>();
        for (Edge e : graph.getEdges())
            if (e.getFrom().getName().equals(current)) neighbors.add(e.getTo().getName());
        Collections.sort(neighbors);
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor) &&
                dfs(graph, neighbor, finish, visited, currentPath, result)) return true;
        }
        currentPath.remove(currentPath.size()-1);
        return false;
    }
}

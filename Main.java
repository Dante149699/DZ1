public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        for (String v : new String[]{"A","B","C","D","E","F"}) graph.addVertex(v);
        graph.addEdge("A","B",1);
        graph.addEdge("B","C",1);
        graph.addEdge("B","D",1);
        graph.addEdge("B","E",1);
        graph.addEdge("C","E",1);
        graph.addEdge("D","E",1);
        graph.addEdge("E","F",1);
        DFS.Result result = new DFS().search(graph,"A","F");
        System.out.println("Порядок обхода DFS: " + String.join(" -> ",result.getOrder()));
        if (result.getPath().isEmpty()) System.out.println("Путь A -> F не найден.");
        else {
            System.out.println("Путь A -> F: " + String.join(" -> ",result.getPath()));
            System.out.println("Количество рёбер: " + (result.getPath().size()-1));
        }
    }
}

public class Tests {
    static void check(boolean ok, String name) {
        System.out.println((ok ? "[OK] " : "[ОШИБКА] ") + name);
        if (!ok) throw new RuntimeException(name);
    }
    public static void main(String[] args) {
        DFS dfs = new DFS();
        Graph g = new Graph();
        for (String v : new String[]{"A","B","C","D","E","F"}) g.addVertex(v);
        g.addEdge("A","B",1); g.addEdge("B","C",1); g.addEdge("B","D",1);
        g.addEdge("B","E",1); g.addEdge("C","E",1); g.addEdge("D","E",1); g.addEdge("E","F",1);
        DFS.Result r = dfs.search(g,"A","F");
        check(r.getOrder().toString().equals("[A, B, C, E, D, F]"),"Основной граф: порядок обхода");
        check(r.getPath().toString().equals("[A, B, C, E, F]"),"Основной граф: путь A-B-C-E-F");
        Graph one = new Graph(); one.addVertex("A");
        check(dfs.search(one,"A","A").getPath().toString().equals("[A]"),"Одна вершина");
        Graph apart = new Graph(); apart.addVertex("A"); apart.addVertex("F");
        check(dfs.search(apart,"A","F").getPath().isEmpty(),"Путь отсутствует");
        Graph cycle = new Graph(); cycle.addEdge("A","B",1); cycle.addEdge("B","C",1); cycle.addEdge("C","A",1);
        check(dfs.search(cycle,"A","C").getPath().toString().equals("[A, B, C]"),"Граф с циклом");
        Graph chain = new Graph(); chain.addEdge("A","B",1); chain.addEdge("B","C",1);
        check(dfs.search(chain,"A","C").getPath().toString().equals("[A, B, C]"),"Граф без цикла");
        DFS.Result again = dfs.search(g,"A","F");
        check(again.getOrder().equals(r.getOrder()) && again.getPath().equals(r.getPath()),"Повторный запуск");
        System.out.println("Все проверки пройдены.");
    }
}

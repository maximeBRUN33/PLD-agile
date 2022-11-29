import java.util.HashMap;


public class GraphConstructer {
    private int[][] map;
    private int[][] graph;
    // HasMap qui permet de transformer l'id des Intersections utiles dans la map à son index associé dans le graph
    private HashMap<Integer, Integer> id_graph_id_map;


    public GraphConstructer(int[][] map, int[] liste_livraisons, int source, HashMap<Integer, Intersection> id_intersections_graph){
        // id_intersections_graph contient les id des Intersections utiles dans la map
        this.map = map;
        int n = liste_livraisons.length + 1;
        this.graph = new int[n][n];

        id_graph_id_map.put(0, source);

        for(int i = 0; i < liste_livraisons.length; i++){
            id_graph_id_map.put(i + 1, liste_livraisons[i]);
        }

        for(int i = 0; i < n; i++){
            int[] result = DijkstraPriorityQueue.dijkstra(map, id_graph_id_map.get(i));
            for(int j = 0; j < n; j++){
                this.graph[i][j] = result[id_graph_id_map.get(j)];
            }
        }

        // Simplifier Graphe en prenant en compte les contraintes horaires
        //this.graph = simplifyGraph();


        // Apply TSP
        TSP tsp = new TSP1();
        Graph g = new CompleteGraph(this.graph);
        tsp.searchSolution(20000, g);

        int totalCostDelivery = tsp.getSolutionCost();
        int[] solutionDelivery = new int[this.graph.length + 1];
        for (int i=0; i<this.graph.length; i++)
            solutionDelivery[i] = tsp.getSolution(i);
        solutionDelivery[this.graph.length] = 0;


        // Reconstruire chemin avec les segments

    }

    public int[][] simplifyGraph(){
        // Yanice code
        return null;
    }

    public int[][] getGraph(){
        return this.graph;
    }
}

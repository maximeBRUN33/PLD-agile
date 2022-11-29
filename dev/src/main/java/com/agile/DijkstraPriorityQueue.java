package com.agile;

import java.util.Comparator;
import java.util.PriorityQueue;


public class DijkstraPriorityQueue {

    public static double [] dijkstra(double [][] graph, int source) {
      int count = graph.length;
      boolean[] sommetsVisites = new boolean[count];
      double[] distance = new double[count];
      PriorityQueue<Node> sommetsNonVisites = new PriorityQueue<Node>();

      for (int i = 0; i < count; i++) {
        if(i != source){
            sommetsNonVisites.add(new Node(i, Integer.MAX_VALUE));
            sommetsVisites[i] = false;
        }
      }
  
      // Pour les boucles de taille 1
      distance[source] = 0;
      for (int i = 0; i < count; i++) {
        Node next_node = sommetsNonVisites.poll();
        int u = next_node.node;
        sommetsVisites[u] = true;
  
        for (int v = 0; v < count; v++) {
          if (!sommetsVisites[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
            distance[v] = distance[u] + graph[u][v];
          }
        }
      }
      return distance;
    }
  
    public static void main(String[] args) {
      double graph[][] = new double [][] { { 0.0, 0.0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 }, { 1, 2, 0, 1, 3, 0, 0 },
          { 2, 0, 1, 0, 0, 0, 1 }, { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0 } };
      DijkstraPriorityQueue T = new DijkstraPriorityQueue();
      double [] result = T.dijkstra(graph, 0);
      System.out.println(result[4]);
    }
  }

  
class Node implements Comparator<Node>
{
    public int node;
    public int cost;
 
    public Node()
    {
    }
 
    public Node(int node, int cost)
    {
        this.node = node;
        this.cost = cost;
    }
 
    @Override
    public int compare(Node node1, Node node2)
    {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;
        return 0;
    }
}
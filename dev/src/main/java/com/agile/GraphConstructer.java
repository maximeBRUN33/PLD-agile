package com.agile;

import java.util.ArrayList;
import java.util.HashMap;

import com.agile.Model.Deliverer;
import com.agile.Model.Delivery;
import com.agile.Model.Intersection;


public class GraphConstructer {
    private double[][] map;
    private double[][] graph;
    // HasMap qui permet de transformer l'id des Intersections utiles dans la map à son index associé dans le graph
    private HashMap<Integer, Integer> id_graph_id_map;


    public GraphConstructer(double[][] map, ArrayList<Delivery> liste_livraisons, int source, HashMap<Integer, Intersection> id_intersections_graph){
        // id_intersections_graph contient les id des Intersections utiles dans la map
        this.map = map;
        int n = liste_livraisons.size() + 1;
        this.graph = new double[n][n];

        id_graph_id_map.put(0, source);

        for(int i = 0; i < liste_livraisons.size(); i++){
            id_graph_id_map.put(i + 1, Integer.valueOf(liste_livraisons.get(i).getPlace().getId()));
        }

        for(int i = 0; i < n; i++){
            double [] result = DijkstraPriorityQueue.dijkstra(map, id_graph_id_map.get(i));
            for(int j = 0; j < n; j++){
                this.graph[i][j] = result[id_graph_id_map.get(j)];
            }
        }

        // Simplifier Graphe en prenant en compte les contraintes horaires
        simplifyGraph(this.graph, liste_livraisons);


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

    public static double [][] simplifyGraph (double [][] matriceAsimplifier, ArrayList<Delivery> listDeliverys)
	{
		Intersection W = new Intersection("W", 0.0, 0.0);
		Deliverer Bill = new Deliverer("Bill");
		Delivery Fake = new Delivery(7.0, 8.0, W, Bill);
		listDeliverys.add(Fake);

		double [][] matriceEtalon = new double [matriceAsimplifier.length][matriceAsimplifier.length];

		for (int i = 0; i < listDeliverys.size(); i++) {
			for (int j = 0; j < listDeliverys.size(); j++) {
				matriceEtalon[i][j] = matriceAsimplifier[i][j];
			}
		}

		double heureMax = 9.0;
		double heureMin = 11.0;
		for (int i = 0; i < listDeliverys.size(); i++) {
			if (listDeliverys.get(i).getArrivalHour() > heureMax)
				heureMax = listDeliverys.get(i).getArrivalHour();
			if (listDeliverys.get(i).getStartHour() < heureMin)
				heureMin = listDeliverys.get(i).getStartHour();
		}
		int offset = 0;
		for (int i = 0; i < listDeliverys.size(); i++) {
			for (int j = 0; j < listDeliverys.size(); j++) {
				if (i != j) {
					if (listDeliverys.get(i).getStartHour() == listDeliverys.get(j).getStartHour()) {
					} else if (listDeliverys.get(i).getStartHour() == listDeliverys.get(j).getArrivalHour()
							+ offset) {
						matriceAsimplifier[i][j] = 0;
					} else if (listDeliverys.get(j).getStartHour() == listDeliverys.get(i).getArrivalHour()
							+ offset) {
						matriceAsimplifier[j][i] = 0;
					} else {
						matriceAsimplifier[j][i] = 0;
						matriceAsimplifier[i][j] = 0;
					}
				}
			}
		}
		for (int j = 0; j < listDeliverys.size(); j++) {
			boolean gap1 = true;
			boolean gap2 = true;
			boolean gap3 = true;
			for (int i = 0; i < listDeliverys.size(); i++) 
				{
					if (listDeliverys.get(j).getStartHour() == listDeliverys.get(i).getArrivalHour()) 
					{
						gap1 = false;
						gap2 = false;
						gap3 = false;
					}
					if (listDeliverys.get(j).getStartHour() == listDeliverys.get(i).getArrivalHour() + 1) 
					{
						gap2 = false;
						gap3 = false;
					}
					if (listDeliverys.get(j).getStartHour() == listDeliverys.get(i).getArrivalHour() + 2) 
					{
						gap3 = false;
					}

				}
			if (gap1)
			{
				for (int i = 0; i < listDeliverys.size(); i++) 
				{
					if (listDeliverys.get(j).getStartHour() == listDeliverys.get(i).getArrivalHour() + 1) 
					{
						matriceAsimplifier[i][j] = matriceEtalon[i][j];
					}
				}
			}
			if (gap2)
			{
				for (int i = 0; i < listDeliverys.size(); i++) 
				{
					if (listDeliverys.get(j).getStartHour() == listDeliverys.get(i).getArrivalHour() + 2) 
					{
						matriceAsimplifier[i][j] = matriceEtalon[i][j];
					}
				}
			}
			if (gap3)
			{
				for (int i = 0; i < listDeliverys.size(); i++) 
				{
					if (listDeliverys.get(j).getStartHour() == listDeliverys.get(i).getArrivalHour() + 3) 
					{
						matriceAsimplifier[i][j] = matriceEtalon[i][j];
					}
				}
			}
		}
		System.out.println(heureMin + " " + heureMax);
		for (int k = 0; k < listDeliverys.size(); k++) {
			for (int l = 0; l < listDeliverys.size(); l++) {
				if (listDeliverys.get(k).getArrivalHour() == heureMin+1 && listDeliverys.get(l).getArrivalHour() == heureMax)
				matriceAsimplifier[l][k] = matriceEtalon[l][k];
			}
		}


		// Affichage des résultats
		System.out.print("  ");
		for (int k = 0; k < listDeliverys.size(); k++) {
			System.out.print(listDeliverys.get(k).getPlace().getId() + " ");
		}
		
		System.out.println();
		for (int k = 0; k < listDeliverys.size(); k++) {
			
			System.out.print(listDeliverys.get(k).getPlace().getId() + " ");
			for (int l = 0; l < listDeliverys.size(); l++) {
				System.out.print(matriceAsimplifier[k][l] + " ");
			}
			System.out.println();
		}
		System.out.println();

		return matriceAsimplifier;
	}

    public double [][] getGraph(){
        return this.graph;
    }
}

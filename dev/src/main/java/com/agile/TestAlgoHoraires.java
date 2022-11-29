package com.agile;

import java.util.ArrayList;

import com.agile.Model.Intersection;
import com.agile.Model.Livraison;
import com.agile.Model.Livreur;

public class TestAlgoHoraires {

	public static void main(String[] args) {
		// Declaration des varialbles de test
		int[][] matriceAdjacence = { { 0, 4, 5, 5, 2 }, { 1, 0, 3, 6, 2 }, { 7, 7, 0, 9, 1 }, { 4, 1, 8, 0, 3 },
				{ 1, 7, 9, 2, 0 } };
		Intersection W = new Intersection("W", 0.0, 0.0);
		Intersection A = new Intersection("A", 0.0, 0.0);
		Intersection B = new Intersection("B", 0.0, 0.0);
		Intersection C = new Intersection("C", 0.0, 0.0);
		Intersection D = new Intersection("D", 0.0, 0.0);
		Livreur Bill = new Livreur("Bill");
		Livraison L4 = new Livraison(11.0, 12.0, A, Bill);
		Livraison L3 = new Livraison(11.0, 12.0, B, Bill);
		Livraison L1 = new Livraison(11.0, 12.0, C, Bill);
		Livraison L2 = new Livraison(11.0, 12.0, D, Bill);
		Livraison Fake = new Livraison(7.0, 8.0, W, Bill);
		ArrayList<Livraison> listLivraisons = new ArrayList<Livraison>();
		
		listLivraisons.add(L1);
		listLivraisons.add(L2);
		listLivraisons.add(L3);
		listLivraisons.add(L4);

		//listLivraisons.add(Fake);

		simplifierMatrice(matriceAdjacence, listLivraisons);
	}

	public static int [][] simplifierMatrice (int [][] matriceAsimplifier, ArrayList<Livraison> listLivraisons)
	{
		Intersection W = new Intersection("W", 0.0, 0.0);
		Livreur Bill = new Livreur("Bill");
		Livraison Fake = new Livraison(7.0, 8.0, W, Bill);
		listLivraisons.add(Fake);

		int [][] matriceEtalon = new int [matriceAsimplifier.length][matriceAsimplifier.length];

		for (int i = 0; i < listLivraisons.size(); i++) {
			for (int j = 0; j < listLivraisons.size(); j++) {
				matriceEtalon[i][j] = matriceAsimplifier[i][j];
			}
		}

		double heureMax = 9.0;
		double heureMin = 11.0;
		for (int i = 0; i < listLivraisons.size(); i++) {
			if (listLivraisons.get(i).getHeureArrivee() > heureMax)
				heureMax = listLivraisons.get(i).getHeureArrivee();
			if (listLivraisons.get(i).getHeureDepart() < heureMin)
				heureMin = listLivraisons.get(i).getHeureDepart();
		}
		int offset = 0;
		for (int i = 0; i < listLivraisons.size(); i++) {
			for (int j = 0; j < listLivraisons.size(); j++) {
				if (i != j) {
					if (listLivraisons.get(i).getHeureDepart() == listLivraisons.get(j).getHeureDepart()) {
					} else if (listLivraisons.get(i).getHeureDepart() == listLivraisons.get(j).getHeureArrivee()
							+ offset) {
						matriceAsimplifier[i][j] = 0;
					} else if (listLivraisons.get(j).getHeureDepart() == listLivraisons.get(i).getHeureArrivee()
							+ offset) {
						matriceAsimplifier[j][i] = 0;
					} else {
						matriceAsimplifier[j][i] = 0;
						matriceAsimplifier[i][j] = 0;
					}
				}
			}
		}
		for (int j = 0; j < listLivraisons.size(); j++) {
			boolean gap1 = true;
			boolean gap2 = true;
			boolean gap3 = true;
			for (int i = 0; i < listLivraisons.size(); i++) 
				{
					if (listLivraisons.get(j).getHeureDepart() == listLivraisons.get(i).getHeureArrivee()) 
					{
						gap1 = false;
						gap2 = false;
						gap3 = false;
					}
					if (listLivraisons.get(j).getHeureDepart() == listLivraisons.get(i).getHeureArrivee() + 1) 
					{
						gap2 = false;
						gap3 = false;
					}
					if (listLivraisons.get(j).getHeureDepart() == listLivraisons.get(i).getHeureArrivee() + 2) 
					{
						gap3 = false;
					}

				}
			if (gap1)
			{
				for (int i = 0; i < listLivraisons.size(); i++) 
				{
					if (listLivraisons.get(j).getHeureDepart() == listLivraisons.get(i).getHeureArrivee() + 1) 
					{
						matriceAsimplifier[i][j] = matriceEtalon[i][j];
					}
				}
			}
			if (gap2)
			{
				for (int i = 0; i < listLivraisons.size(); i++) 
				{
					if (listLivraisons.get(j).getHeureDepart() == listLivraisons.get(i).getHeureArrivee() + 2) 
					{
						matriceAsimplifier[i][j] = matriceEtalon[i][j];
					}
				}
			}
			if (gap3)
			{
				for (int i = 0; i < listLivraisons.size(); i++) 
				{
					if (listLivraisons.get(j).getHeureDepart() == listLivraisons.get(i).getHeureArrivee() + 3) 
					{
						matriceAsimplifier[i][j] = matriceEtalon[i][j];
					}
				}
			}
		}
		System.out.println(heureMin + " " + heureMax);
		for (int k = 0; k < listLivraisons.size(); k++) {
			for (int l = 0; l < listLivraisons.size(); l++) {
				if (listLivraisons.get(k).getHeureArrivee() == heureMin+1 && listLivraisons.get(l).getHeureArrivee() == heureMax)
				matriceAsimplifier[l][k] = matriceEtalon[l][k];
			}
		}


		// Affichage des résultats
		System.out.print("  ");
		for (int k = 0; k < listLivraisons.size(); k++) {
			System.out.print(listLivraisons.get(k).getLieu().getId() + " ");
		}
		
		System.out.println();
		for (int k = 0; k < listLivraisons.size(); k++) {
			
			System.out.print(listLivraisons.get(k).getLieu().getId() + " ");
			for (int l = 0; l < listLivraisons.size(); l++) {
				System.out.print(matriceAsimplifier[k][l] + " ");
			}
			System.out.println();
		}
		System.out.println();

		return matriceAsimplifier;
	}
}

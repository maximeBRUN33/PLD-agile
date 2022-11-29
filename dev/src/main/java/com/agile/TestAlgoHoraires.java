package com.agile;

import java.util.ArrayList;

import com.agile.Model.Intersection;
import com.agile.Model.Delivery;
import com.agile.Model.Deliverer;

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
		Deliverer Bill = new Deliverer("Bill");
		Delivery L4 = new Delivery(11.0, 12.0, A, Bill);
		Delivery L3 = new Delivery(11.0, 12.0, B, Bill);
		Delivery L1 = new Delivery(11.0, 12.0, C, Bill);
		Delivery L2 = new Delivery(11.0, 12.0, D, Bill);
		Delivery Fake = new Delivery(7.0, 8.0, W, Bill);
		ArrayList<Delivery> listDeliverys = new ArrayList<Delivery>();
		
		listDeliverys.add(L1);
		listDeliverys.add(L2);
		listDeliverys.add(L3);
		listDeliverys.add(L4);

		//listDeliverys.add(Fake);

		simplifierMatrice(matriceAdjacence, listDeliverys);
	}

	public static int [][] simplifierMatrice (int [][] matriceAsimplifier, ArrayList<Delivery> listDeliverys)
	{
		Intersection W = new Intersection("W", 0.0, 0.0);
		Deliverer Bill = new Deliverer("Bill");
		Delivery Fake = new Delivery(7.0, 8.0, W, Bill);
		listDeliverys.add(Fake);

		int [][] matriceEtalon = new int [matriceAsimplifier.length][matriceAsimplifier.length];

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
}

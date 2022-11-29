import java.util.iterator; 


public class FromXMLtoTSP {
	
	public static void main {
		
		double [][] carte = ParserXML.getmap();
		
		ListToMatrix(carte.intersections, carte.segments);
		
	}
	
	public double[][]  ListToMatrix (HashMap<String, Intersection> intersections , ArrayList<Segment> segments){

		
        Map<String, Integer> map_id_int = new HashMap<String, Integer>();
        
        int index = 0;
                
        for (Map.Entry<String, Intersection> entry : intersections.entrySet()) {
        
        	map_id_int.put(entry.getValue().getId() , index);
            ++index;
        	
        }

        double[][] matrix_adjacent = new double[intersections.size()][intersections.size()];
        
        for (Segment s : segments){
            matrix_adjacent[map_id_int.get(s.getDepart().getId())][map_id_int.get(s.getArrivee().getId())] = s.getLongueur();
        }
        System.out.println();
        for (int i = 0 ; i < matrix_adjacent.length ; ++i){

            for (int j = 0 ; j  < matrix_adjacent[0].length ; ++j){

                System.out.print("\t");
                System.out.print( matrix_adjacent[i][j]);
                System.out.print("           ");

            }

            System.out.print("\n");

        }

        return matrix_adjacent;

    }
}

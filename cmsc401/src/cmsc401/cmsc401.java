import java.util.Scanner;
import java.util.LinkedList;

public class cmsc401 
{

	public static void main(String[] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		int CitiesV = scanner.nextInt();
		int RoadsE = scanner.nextInt();
		LinkedList<String> numHotels = new LinkedList<String>();
		numHotels.add("1");
		numHotels.add("2");
		int i = 1;
		LinkedList<String> numStations = new LinkedList<String>(); 

		while(scanner.hasNextLine() && i<=CitiesV-2)
		{
			String temp1;
			temp1 = scanner.next() + "|" + scanner.next();
			numHotels.add(temp1);
			i++;
		}
		int j = 1;
		while(scanner.hasNextLine() && j<=RoadsE)
		{
			String temp2;
			temp2 = scanner.next() + "|" + scanner.next() + "|" + scanner.next();
			numStations.add(temp2);
			j++;
		}
		scanner.close();

		Vertex[] vertices = new Vertex[CitiesV];
		Edge[] edges = new Edge[RoadsE*2];
		vertices[0] = new Vertex("1");
		vertices[1] = new Vertex("2");

		for(int k=2; k<numHotels.size();k++)
		{
			String vertexFull = numHotels.get(k);
			String[] nextkens = vertexFull.split("\\|");
			Vertex newVertex = new Vertex(nextkens[0]);
			vertices[k] = newVertex;
		}

		int cnt = 0;

		for(int a=0; a < numStations.size(); a++)
		{
			String edgeFull = numStations.get(a);
			String[] nextkens = edgeFull.split("\\|");
			String vertex1 = nextkens[0];
			String vertex2 = nextkens[1];
			int edgeCost = Integer.parseInt(nextkens[2]);
			Vertex vertexObject1 = null;
			Vertex vertexObject2 = null;

			for(int b=0; b < vertices.length; b++)
			{
				Vertex tempVertex = vertices[b];
				String name = tempVertex.getVertex();
				if(name.equals(vertex1))
				{
					vertexObject1 = tempVertex;
				}
				if(name.equals(vertex2))
				{
					vertexObject2 = tempVertex;
				}
			}
			int hotelVersaVice = 0;
			for(int b=0; b<numHotels.size(); b++)
			{
				String vertexFull2 = numHotels.get(b);
				String delimeter2 = "\\|";
				String[] nextkens2 = vertexFull2.split(delimeter2);
				if(nextkens2[0].equals(vertex2) && nextkens2.length > 1)
				{
					hotelVersaVice = Integer.parseInt(nextkens2[1]);
				}
			}

			int hotelViceVersa = 0;
			for(int b=0; b < numHotels.size(); b++)
			{
				String vertexFull2 = numHotels.get(b);
				String delimeter2 = "\\|";
				String[] nextkens2 = vertexFull2.split(delimeter2);
				if(nextkens2[0].equals(vertex1) && nextkens2.length > 1)
				{
					hotelViceVersa = Integer.parseInt(nextkens2[1]);
				}
			}
			Edge Edg = new Edge(vertexObject1,vertexObject2,edgeCost+hotelVersaVice);
			Edge Edg1 = new Edge(vertexObject2,vertexObject1,edgeCost+hotelViceVersa);

			edges[cnt] = Edg;
			edges[cnt+1] = Edg1;
			cnt = cnt + 2;
		}
		Algorithm dij = new Algorithm(vertices, edges);
		dij.getDijk(vertices[0],vertices[1]);
		dij.prntStatement(vertices[0],vertices[1]);
	}
}

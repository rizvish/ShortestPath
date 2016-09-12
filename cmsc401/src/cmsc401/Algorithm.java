
import java.util.*;

public class Algorithm 
{
	Vertex vertex; 
	Edge[] edges; 
	ArrayList<Vertex> list = new ArrayList<Vertex>(); 

	public ArrayList<Vertex> settingL(Vertex current, Vertex next)  
	{
		list.add(0, next);

		while (next != null) 
		{
			list.add(0, next);
			next = next.getcurrent();
		}  
		return list;
	}
	public Algorithm(Vertex[] vertices, Edge[] edges) 
	{
		this.edges = edges;  
		for (int i = 0; i < vertices.length; i++) 
		{
			list.add(vertices[i]);
		}
	}
	public int setPoint(Vertex current) 
	
	{
		if (current.getnexttal() == (int)Double.POSITIVE_INFINITY || current.getnexttal() < 0) 
		{
			current.setnexttal(0);
		}
		return current.getnexttal();
	}

	public Vertex movePoint(Vertex current, Vertex next) 
	{
		Vertex movePoint = current;
		for (int i = 0; i < list.size(); i++) 
		{
			if (list.get(i).getcheckVert() == false) 
			{
				movePoint = list.get(i);
				break;
			}
		}
		for (int j = 0; j < list.size(); j++) 
		{
			if (list.get(j).getcheckVert() == false) 
			{
				if (list.get(j).getnexttal() < movePoint.getnexttal()) 
				{
					movePoint = list.get(j);
				}
			}
		}
		return movePoint;
	}
	
	public void prntStatement(Vertex current, Vertex next) 
	{
		System.out.println(next.getnexttal());
	}
	public void getDijk(Vertex current, Vertex next) 
	{
		while (current.getcheckVert() == false) 
		{
			setPoint(current);
			for (int i = 0; i < edges.length; i++) 
			{
				if (current.equals(edges[i].getcurrent()) && current.getcurrent() != (edges[i].getnext())) 
				{
					if (current.getnexttal() + edges[i].getgasP() < edges[i].getnext().getnexttal()) 
					{
						edges[i].getnext().setnexttal(current.getnexttal() + edges[i].getgasP());
						edges[i].getnext().setcurrent(current);
					}
				}
			}
			current.setcheckVert();
			current = movePoint(current, next);
		}
	}
}

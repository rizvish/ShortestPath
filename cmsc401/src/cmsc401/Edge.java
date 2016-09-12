
public class Edge
{
	private Vertex current;
	private Vertex next;
	private int gasP;

	public Edge(Vertex current, Vertex next, int gasP) 
	{
		this.current = current;
		this.next = next;
		this.gasP = gasP;
	}

	public void setcurrent(Vertex current) 
	{
		this.current = current;
	}

	public Vertex getcurrent() 
	{
		return current;
	}

	public void setnext(Vertex next) 
	{
		this.next= next;
	}

	public Vertex getnext() 
	{
		return next;
	}

	public void setgasP(int gasP) 
	{
		this.gasP = gasP;
	}

	public int getgasP() 
	{
		return gasP;
	}
}
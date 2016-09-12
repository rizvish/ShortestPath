
public class Vertex 
{
	private String vertex;
	private Vertex current;
	private int nexttal;
	private boolean checkVert = false;

	public Vertex(String vertex) 
	{
		this.vertex = vertex;
		this.current = null;
		this.nexttal = (int) Double.POSITIVE_INFINITY;
	}

	public void setVertex(String vertex) 
	{
		this.vertex = vertex;
	}

	public String getVertex() 
	{
		return vertex;
	}

	public void setcurrent(Vertex current) 
	{
		this.current = current;
	}

	public Vertex getcurrent() 
	{
		return current;
	}

	public void setnexttal(int nexttal) 
	{
		this.nexttal = nexttal;
	}

	public int getnexttal() 
	{
		return nexttal;
	}

	public void setcheckVert() 
	{
		this.checkVert = true;
	}

	public boolean getcheckVert() 
	{
		return checkVert;
	}
}
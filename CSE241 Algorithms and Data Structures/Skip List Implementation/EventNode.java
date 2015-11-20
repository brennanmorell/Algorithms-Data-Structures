import java.util.ArrayList;


public class EventNode {

	public EventNode[] pillar;
	public int key;
	public ArrayList<Event> events;
	public int height;
	
	
	public EventNode(int ikey, int iheight)
	{
		key = ikey;
		pillar = new EventNode[iheight];
		height = iheight;
		events = new ArrayList<Event>();
	}
}

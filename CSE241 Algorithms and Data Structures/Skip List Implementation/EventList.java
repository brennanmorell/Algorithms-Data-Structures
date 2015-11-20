//
// EVENTLIST.JAVA
// Skeleton code for your EventList collection type.
//
import java.util.*;

class EventList {
    
    Random randseq;
    
    ////////////////////////////////////////////////////////////////////
    // Here's a suitable geometric random number generator for choosing
    // pillar heights.  We use Java's ability to generate random booleans
    // to simulate coin flips.
    ////////////////////////////////////////////////////////////////////
    
    int randomHeight()
    {
	int v = 1;
	while (randseq.nextBoolean()) { v++; }
	return v;
    }

    public EventNode head;
    public EventNode tail;
    
    //
    // Constructor
    //
    public EventList()
    {
    	randseq = new Random(58243); // You may seed the PRNG however you like.
    	head = new EventNode(-1,1);
    	tail = new EventNode(Integer.MAX_VALUE,1);
    	head.pillar[0] = tail;	
    }

    public void extendHead()
    {
    	int oldHeight = head.pillar.length;
		
		EventNode[] copy = head.pillar;
		
		head.pillar = new EventNode[oldHeight*2];
		
		for(int i = 0; i < oldHeight; i++) //set all the previously existing pointers
		{
			head.pillar[i] = copy[i];
		}
		
		for(int i = oldHeight; i < head.pillar.length; i++) //for all the new pointers, point them to tail
		{
			head.pillar[i] = tail;
		}
    }
    
    public void extendTail()
    {
    	int oldHeight = tail.pillar.length;
		tail.pillar = new EventNode[oldHeight*2];
    }
    
    //
    // Add an Event to the list.
    //
    public void insert(Event e)
    {
    	EventNode found = find(e.year);
    	if(found != null)
    	{
    		found.events.add(e);
    		return;
    	}
    	
    	
    	int t = randomHeight();
    	EventNode node = new EventNode(e.year,t);
    	node.events.add(e);
    	
    	while(t > head.pillar.length)
    	{
    		extendTail();
    		extendHead();
    	}
    	
    	int l = head.pillar.length-1;
    	EventNode x = head;
    	
    	while(l >= 0)
    	{
    		EventNode y = x.pillar[l];
    		
    		if(y.key < e.year)
    		{
    			x = y;
    		}
    		else
    		{
    			if(l < t)
    			{	
    				x.pillar[l] = node;
    				node.pillar[l] = y;
    			}
    			
    			l--;	
    		}
    	}	 	
    }
    
    //
    // Remove all Events in the list with the specified year.
    //
    public void remove(int year)
    {
    	
    	int l = head.height-1;
    	EventNode x = head;
    	
    	while(l >= 0)
    	{
    		EventNode y = x.pillar[l];
    		if(y.key < year)
    		{
    			x = y;
    		}
    		else
    		{
    			if(y.key == year)
    			{
					for(int i = 0; i < x.height; i++)
					{
						if(i < y.height)
						{
							x.pillar[i] = y.pillar[i];
						}
					}
					
					return;
    			}
    			
    			l--;
    		}
    		
    	}
    }
    

    
    public EventNode find(int year)
    {
       int l = head.height -1;
       EventNode x = head;
       
       while(l >= 0)
       {
    	   EventNode y = x.pillar[l];
    	   
    	   if(y.key == year)
    	   {
    		   return y;
    	   }
    	   else
    	   {
    		   if(y.key < year)
    		   {
    			   x = y;
    		   }
    		   else
    			   l--;
    	   }
       }
       
       return null;
        
    }
    
    //
    // Find all events with greatest year <= input year
    //
    public Event [] findMostRecent(int year)
    {
    	Event[] result = new Event[0];
    	
    	int l = head.height-1;
    	EventNode x = head;
    	
    	while(l >= 0)
    	{
    		EventNode y = x.pillar[l];
    		if(y.key < year)
    		{
    			x = y;
    		}
    		else
    		{
    			if(y.key == year)
    			{
    				result = new Event[y.events.size()];
    				y.events.toArray(result);
    				return result;
    			}
    			
    			l--;
    		}
    		
    	}
    	
    	result = new Event[x.events.size()];
    	x.events.toArray(result);
    	return result;
    	
    }
    
    
    //
    // Find all Events within the specific range of years (inclusive).
    //
    public Event [] findRange(int first, int last) //wrong
    {
    	int l = head.height -1;
    	
    	EventNode x = head;
    	
    	ArrayList<Event> range = new ArrayList<Event>();
    	
    	while(l >= 0)
    	{
    		EventNode y = x.pillar[l];
    		if(y.key == first)
    		{
    			x = y;
    			break;
    		}
    		else if(y.key < first)
    		{
    			x = y;
    		}
    		else
    		{
    			l--;
    		}
    	}
    	
    	if(x.key < first)
    	{
    		x = x.pillar[0];
    	}
    	
    	while(x.key <= last)
    	{
    	
    		for(int i = 0; i < x.events.size(); i++)
    		{
    			range.add(x.events.get(i));
    		}
    			
    		x = x.pillar[0];
    	}
    	
    	Event[] result = new Event[range.size()];
    	range.toArray(result);
    	return result;
    }	
    	
}

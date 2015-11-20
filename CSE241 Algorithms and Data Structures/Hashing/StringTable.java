//
// STRINGTABLE.JAVA
// A hash table mapping Strings to their positions in the the pattern sequence
//
public class StringTable {
   
	private Record[] table;
	private int numLoaded;
	private double loadBound;
	
    public StringTable(int maxSize) 
    {
    	table = new Record[2];
    	numLoaded = 0;
    	loadBound = .25;
    }
    
    public void doubleSize()
    {
    	Record[] copy = new Record[table.length];
    	for(int i = 0; i < table.length; i++)
    	{
    		if(table[i] != null && !(table[i].key.equals("deleted")))
    		{
	    			copy[i] = table[i];
    		}
    	}
    	
    	table = new Record[table.length*2];
    	
    	for (Record r : copy)
    		if(r != null)
    			insert(r);
    }
    //
    // Insert a Record r into the table.  Return true if
    // successful, false if the table is full.  
    //
    public boolean insert(Record r) 
    { 
    	if(((double)numLoaded+1)/table.length <= loadBound)
    	{
	    	int k = toHashKey(r.key); 
	    	int slot = baseHash(k)%table.length;
	    	
	    	if(table[slot] == null)
	    	{
	    		r.hashValue = k;
	    		table[slot] = r;
	    		numLoaded++;
	    		return true;
	    	}
	    	else
	    	{
	    		
	    		int i = 1;
	    		int increment = stepHash(k)%table.length;
	    		
	    		while(i < table.length)
	    		{
	    			slot = (slot + increment)%table.length;
	    			
	    			if(table[slot] == null)
	    			{
	    				r.hashValue = k;
	    				table[slot] = r;
	    				numLoaded++;
	    				return true;
	    			}
	    			
	    		
	    			i++;
	    		}
    		
	    		return false;
	    	}
    	}
    	else
    	{
    		doubleSize();
    		return insert(r);
    	}
    	
    }
    
    
    //
    // Delete a Record r from the table.  
    //
    public void remove(Record r) 
    {
    	//System.out.println("Trying Remove: " + r.key);
    	Record match = find(r.key);
    	match.key = "deleted";
    	
    }
    
    
    //
    // Find a record with a key matching the input.  Return the
    // record if it exists, or null if no matching record is found.
    //
    public Record find(String key) 
    {
    	int k = toHashKey(key); 
    	int slot = baseHash(k)%table.length;
    	
    	if(table[slot] != null)
    	{
    		if(table[slot].hashValue == k)
    		{
	    		if(table[slot].key.equals(key))
	    		{
	    			return table[slot];
	    		}
    		}
    		
    			
        		int i = 1;
        		int increment = stepHash(k)%table.length;
        		
        		while(i < table.length)
        		{
        			slot = (slot + increment)%table.length;
        			
        			if(table[slot] != null)
        			{
        				if(table[slot].key.equals(key))
        				{
        					return table[slot];
        				}
        				
        			}
        			else
        			{
        				return null;
        			}
        			
        			i++;
        		}
    	}
    	
    	return null;
    	
    }
  
    int toHashKey(String s)
    {
	int A = 1952786893;
	int B = 367257;
	int v = B;
	
	for (int j = 0; j < s.length(); j++)
	    {
		char c = s.charAt(j);
		v = A * (v + (int) c + j) + B;
	    }
	
	if (v < 0) v = -v;
	return v;
    }
    
    int baseHash(int hashKey)
    {
    	double A = Math.sqrt(2)/2;
    	return ((int)Math.floor(table.length*((hashKey*A)-Math.floor(hashKey*A))));
    }
    
    int stepHash(int hashKey)
    {
    	double A = Math.sqrt(5)/3;
    	int result =  ((int)Math.floor(table.length*((hashKey*A)-Math.floor(hashKey*A))));
    	if(result%2 == 0)
    		return result + 1;
    	else
    		return result;
    }
}

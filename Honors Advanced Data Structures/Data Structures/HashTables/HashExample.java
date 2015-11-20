public class HashExample
{
	private ListNode[] hashTable;
	private int size;
	
	public HashExample(int tableSize)
	{
		size = tableSize;
		hashTable = new ListNode[tableSize];// more code here		

	}
	
	public void put(String item)
	{
	
		int temp = item.hashCode();
		ListNode itemNode = new ListNode(item,null);
		temp = Math.abs(temp) % size;
		if(hashTable[temp] == null)
		{
			hashTable[temp] = itemNode;
		}
		else
			{
				hashTable[temp] = new ListNode(item,hashTable[temp]);
			}
			
		
		// more code here
                
		// compute index using hashCode method of String class
		//	remember:  this might be a negative value
		// perform approriate arithmetic operation to ensure it is in range
		
		// check if this table entry is occupied - if not use it
		//	otherwise 'chain' this item to existing item

			
	}	
	
	public int find(String item)
	{
		int hashCode = item.hashCode();
		int hashCodeinTable = Math.abs(hashCode) % size;
		if(hashTable[hashCodeinTable] != null && hashTable[hashCodeinTable].getValue().equals(item))
		{
			return hashCodeinTable;
		}
		else
			if(hashTable[hashCodeinTable] != null)
			{
				ListNode temp = hashTable[hashCodeinTable];
				while(temp != null)
				{
					if(temp.getValue().equals(item))
					{
						return hashCodeinTable;
					}
					temp = temp.getNext();
				}
			}
			return -1;
		
		// more code here
		
	}
	public String toString()
	{
		String returner = "";
		ListNode temp;
		
		for(int i = 0; i < hashTable.length; i++)
		{
			temp = hashTable[i];
			if(temp != null)
			{
				while(temp != null)
				{
					returner += temp.getValue() + "\t";
					temp = temp.getNext();
				}
				
				returner += "\n";
			}
			else
				{
					returner += "\n";
				}
			
		}
		
		return returner;
	}
	
	public static void main(String[] args)
	{
		EasyReader console = new EasyReader();
		System.out.print("Enter table size: ");
		
		int size = console.readInt();
		HashExample hash = new HashExample(size);
		
		String item = "";
		while (!item.equals("end"))
		{
			System.out.print("Enter item to insert(end to exit): ");

			item = console.readWord();
			if (!item.equals("end"))
			{
				hash.put(item);
				System.out.println(hash);
			}	
		}
		item="";
		while (!item.equals("end"))
		{
			System.out.print("Enter item to find(end to exit): ");

			item = console.readWord();
			if (!item.equals("end"))
			{
				if (hash.find(item)!=-1)
					System.out.println("In Table at location "+hash.find(item));
				else
					System.out.println("Not In Table");	
			}
		}
		
			
		
	}
		
}
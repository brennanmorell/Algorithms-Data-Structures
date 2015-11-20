import java.util.*;
public class MyHashSet implements Iterable,Iterator
{
	private ListNode[] hashTable;
	private int size;
	private int bucketCount;
	private ListNode current;
	private int count;  //num of items
	
	public MyHashSet()
	{
		hashTable = new ListNode[5];
		bucketCount = 0;
		current = null;
		count = 0;
	
	}
	
	public boolean hasNext()//int counter
	{
		if(count >= size)
		{
			return false;
		}
		else
			return true;
				
	
	}
	
	public void remove()
	{
	}
	
	
	public Iterator iterator()
	{
		current = null;
		return this;
	}
	
	public Object next() //next method: return value of node; if next node isnt null advance iterator; else move down a bucket
	{
		if(!this.hasNext())
		{
			throw new NoSuchElementException();
		}
		else
			{
				if(current != null)
				{
					current = current.getNext();
				}
				else
					{
						current = hashTable[bucketCount];
					}
				
		
				while(current == null && bucketCount < hashTable.length)
				{
					bucketCount++;
					current = hashTable[bucketCount];
				}
			
				count++;
				return current.getValue();
			}	
		
	}
	
	public boolean add(Object item)
	{
		int code = item.hashCode() % hashTable.length;
		ListNode temp = new ListNode(item,null);
		if(hashTable[code] == null)
		{
			hashTable[code] = temp;
			size = size() + 1;
			return true;
		}
		else
			{
				if(!contains(item))
				{
					hashTable[code] = new ListNode(item,hashTable[code]);
					size = size() + 1;
					return true;
				}
				else	
					return false;
				
			}
	}	
	
	public boolean contains(Object item)
	{
		int code = item.hashCode() % hashTable.length;
		if(hashTable[code] == null)
		{
			return false;
		}
		else
		{
			ListNode temp = hashTable[code];
			for(ListNode curr = temp; curr != null; curr = curr.getNext())
			{
				if(curr.getValue().equals(item))
				{
					return true;
				}
				temp = curr.getNext();
			}
			return false;
		}
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
	
	
	public boolean remove(Object item)
	{
		if(!contains(item))
		{
			return false;
		}
		else
			{
				int code = item.hashCode() % hashTable.length;
				ListNode temp = hashTable[code];
				ListNode prev = hashTable[code];
				
				int count = 0;
				for(ListNode curr = temp; curr != null; curr = curr.getNext())
				{
					if(count == 0) //you are at first node
					{
						if(curr.getValue().equals(item))
						{
							if(curr.getNext() == null) //first node is target and only node in list
							{
								hashTable[code] = null;
								size = size() -1;//set bucket to null
								return true;
							}
							else //if there is more than one and you are at first node
								{
									ListNode n = curr.getNext();
									hashTable[code] = n;
									size = size() -1;
									return true;
								}
						}
					}
					else //you are not at the first node
						{	
							if(curr.getValue().equals(item)) //if its the target
							{
								prev.setNext(curr.getNext());
								size = size() -1;
								return true;
							}
							
							prev = prev.getNext();
						}
						
						count++;
						
						
				}
				return false;
			}
	}	
			

	public int size()
	{
		return size;
	}
		
	
	public static void main(String[] args)
	{
		EasyReader console = new EasyReader();
		MyHashSet hs = new MyHashSet();
		
		String item = "";
		while (!item.equals("end"))
		{
			System.out.print("Enter item to insert(end to exit): ");

			item = console.readWord();
			if (!item.equals("end"))
			{
				if ( !hs.add(item) ) System.out.println("not added, already in set");
				System.out.println(hs);
			}	
		}
		item = "";

				System.out.println(hs);
				System.out.println("Size: " + hs.size);
				System.out.println("");                    
		
			for(Object obj : hs)
			System.out.print(obj);


		while (!item.equals("end"))
		{
			System.out.print("Enter item to remove(end to exit): ");

			item = console.readWord();
			if (!item.equals("end"))
			{
				if ( !hs.remove(item) ) System.out.println("not in set");
				System.out.println(hs);
			}	
		}
		
			
		
	}
		
}
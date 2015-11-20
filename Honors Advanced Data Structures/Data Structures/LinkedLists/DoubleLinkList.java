public class DoubleLinkList
{
	private DNode head;
	private DNode tail;
	
	public static void main (String args[])
	{
		DoubleLinkList list = new DoubleLinkList();
		
		String item;
 		EasyReader console = new EasyReader();
		
		int choice;
		do
		{
			System.out.println("Enter choice:");
			System.out.println("1. Add item to head of list");
			System.out.println("2. Add item to end of list");
			System.out.println("3. Delete item from list");
			System.out.println("4. Add item in order");
			System.out.println("5. Print list");
			System.out.println("6. Print Reversed Version");
			System.out.println("7: Delete item from front of list");
			System.out.println("8: Delete item from back of list");
			System.out.println("9: EXIT");
		
			choice = console.readInt();
		
			if(choice == 1)
			{
				System.out.print("Enter item: ");
				item = console.readWord();
				list.addToFront(item);
			}
			if(choice == 5)
			{
				System.out.println(list);
			}
			if(choice == 3)
			{
				System.out.println("Enter item: ");
				item = console.readWord();
				list.removeItem(item); 
			}
			
			if(choice == 4)
			{
				System.out.println("Enter item: ");
				item = console.readWord();
				list.addInOrder(item);
			}
			
			if(choice == 2)
			{
				System.out.println("Enter Item: ");
				item = console.readWord();
				list.addToEnd(item);
			}
			
			if(choice == 6)
			{
				list.printBackwards();
			}
			
			if(choice == 7)
			{
				list.DeleteFromFront();
			}
				
			if(choice == 8)
			{
				list.DeleteFromBack();
			}
								
		}
		
		while(choice != 9);

	}
	
	public void addToFront(String item)
	{
		DNode myNode = new DNode(null, item, null);
		if(head == null)
		{
			head = myNode;
			tail = myNode;
		}
		else
			{
				myNode.setNext(head);
				head.setPrev(myNode);
				head = myNode;
			}
		
	}
	
	public void addInOrder(String item)
	{
		DNode curr = head;
		DNode prev = head;
		
		if(head != null)
		{
			while(((Comparable)item).compareTo(curr.getValue()) >= 0 && curr.getNext() != null)
			{
				curr = curr.getNext();
			}
		
			if(curr.getNext() == null)
			{
				addToEnd(item);
			}
			
			else
			
				if(curr == head)
				{
					addToFront(item);
						
				}
				
				else
					{
						DNode temp = curr.getPrev();
						DNode insert = new DNode(null,item,null);
						temp.setNext(insert);
						insert.setPrev(temp);
						insert.setNext(curr);
					}
					
			
		}
		
		else
			
			addToFront(item);
	}
		
	
	public void addToEnd(String item)
	{
		DNode myNode = new DNode(tail, item, null);
		if(head == null)
		{
			tail = myNode;
			head = tail;
		}
		
		else
			{
				tail.setNext(myNode);
				tail = myNode;
			}
	}
	
	public void removeItem(String item)
	{
		DNode curr = head;
		
		if(head != null)
		{
		
				while(!(curr.getValue().equals(item)) && curr.getNext() != null)
				{
					curr = curr.getNext();
			
				}
			
				if(curr.getValue().equals(item))
				{
					if(curr != head && curr != tail)
					{
						curr.getPrev().setNext(curr.getNext());
						curr.getNext().setPrev(curr.getPrev());
					}
					
					else
						if(curr == head)
						{
							DeleteFromFront();
						}
						
						else
							
							if(curr == tail)
							{
								DeleteFromBack();
							}
				}
		}
			
	}
	
	public void DeleteFromFront()
	{
		if(head == null)
		{
			
		}
		else
			
			if(head.getNext() == null)
			{
				head = null;
				tail = null;
			}
		
			else
				{
			
					head = head.getNext();
					head.setPrev(null);
				
					if(head.getNext() == null)
					{
						tail = head;
					}
				}
	}
	
	public void DeleteFromBack()
	{
		if(tail == null)
		{
		}
		else
			if(tail.getPrev() == null)
			{
				head = null;
				tail = null;
				
			}
			
			else
				{
					
					tail = tail.getPrev();
					tail.setNext(null);
			
				
					if(tail.getPrev() == null)
					{
						head = tail;
					}
				}
	}
	
	public void printBackwards()
	{
	
		//System.out.println("Tail: " + tail.getValue());
		for(DNode curr = tail; curr!=null; curr = curr.getPrev())
		{
			System.out.print(curr.getValue());
			if (curr.getPrev() != null)
				System.out.print("-->");
		}
		
		System.out.println("");
	}
	
	public String toString()
	{
		String result = "";
		for (DNode curr = head; curr != null; curr = curr.getNext())
		{
			result += curr.getValue();
			if (curr.getNext() != null)
				result += "-->";
					
		}
		return result;
	}
	
	
	
	
	
}


		
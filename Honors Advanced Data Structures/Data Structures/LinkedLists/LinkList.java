
public class LinkList
{
	private ListNode head;
	
	public void addToFront(Object item)
	{
		head = new ListNode(item,head);
	}
	
	public String toString()
	{
		String result = "";
		for (ListNode curr = head; curr != null; curr = curr.getNext())
		{
			result += curr.getValue();
			if (curr.getNext() != null)
				result += "-->";
					
		}
		return result;
	}
	
	public void addToEnd(Object item)
	{
		
		ListNode curr = head;
		if(curr != null)
		{
			for(curr = head; curr.getNext() != null; curr = curr.getNext())
			{
			}
		
			ListNode temp = new ListNode(item,null);	
			curr.setNext(temp);	
		}
		
		else
			{
				ListNode temp1 = new ListNode(item,null);
				head = temp1;
			}
	}
	
	public void deleteItem(Object item)
	{
		ListNode curr = head;
		ListNode prev = head;
		boolean found = false;
		
		if( curr != null)
		{
			for(curr = head; curr.getNext() != null; curr = curr.getNext())
			{
			
				if(curr.getValue().equals(item) && curr.equals(head))
				{
					head = head.getNext();
					found = true;
				
				
				}
			
				else
				
					if(curr.getValue().equals(item) && curr != head && curr.getNext() != null)
					{
						prev.setNext(curr.getNext());
						found = true;
					}
				
					else
					
						if(curr.getValue().equals(item) && curr != head && curr.getNext().equals(null))
						{
							prev.setNext(null);
							found = true;
						}
		
						prev = curr;
			}
		
		
		}
		
	
		
	}
	
	public void addInOrder(Object item)
	{
		ListNode curr = head;
		ListNode prev = head;
		ListNode insert = new ListNode(item,null);
		
		if(head != null)
		{
			if(((Comparable)item).compareTo(curr.getValue()) < 0)
			{
				head = insert;
				insert.setNext(curr);
			}
			else
				{
					while(curr != null &&  ((Comparable)item).compareTo(curr.getValue()) >= 0)
					{
						prev = curr;
						curr = curr.getNext();
		
					}
		
	
					prev.setNext(insert);
					insert.setNext(curr);
				}
	
		}
		
		else 
		
			head = insert;
	}		
				
	
	
	
	
	
	
	
	
	public static void main (String args[])
	{
		LinkList list = new LinkList();
		
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
			System.out.println("6. Exit");
			
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
				list.deleteItem(item); 
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
				
								
		}
		
		while(choice != 6);

	}
	
}
		
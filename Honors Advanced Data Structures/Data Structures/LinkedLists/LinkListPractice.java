
public class LinkListWS{


	private ListNode head;
	
	public void add(Object item){
		ListNode node = new ListNode(item,head);
		head = node;
	}
	

	public int size()
	{
		return size(head);
		
	}
	
	public int size(ListNode head)
	{
		if(head == null)
		{
			return 0;
		}
		
		else

			return 1 + size(head.getNext());
	}
		
	public void rotate()
	{
		head = rotate(head);
	}
	
	public ListNode rotate(ListNode list)
	{
		Object temp = head.getValue();
		head = head.getNext();
		ListNode temp2 = head;
		while(temp2.getNext() != null)
		{
			temp2 = temp2.getNext();
		}
		ListNode last = new ListNode(temp,null);
		temp2.setNext(last);
		return head;
	


	}			

	
	public String toString()
	{
		String result = "";
		for (ListNode curr = head; curr != null; curr = curr.getNext())
		{
			result += "--->"+curr.getValue();
		}
		result += "\n";
		return result;
	}
	

	public void makeList(String[] arr)
	{
		head = toLinkedList(arr);
	}

	public ListNode toLinkedList(String[] arr)
	{
		ListNode head = new ListNode(arr[0],null);
		ListNode prev = head;
		for(int i = 1; i < arr.length; i++)
		{
			ListNode temp = new ListNode(arr[i],null);
			prev.setNext(temp);
			prev = prev.getNext();
		}
		
		return head;

	}		
	public static void main (String args[])
	{
		LinkListWS list = new LinkListWS();
		String item;
 		EasyReader console = new EasyReader();
 		String[] arr = {"this","is","a","test"};
		list.makeList(arr);
		System.out.println(list);
	//	list = new LinkListWS();		
		int choice;
		do{
					
		System.out.println("Enter choice:");
		System.out.println("1. Add item to head of list");
		System.out.println("2. Print list");
		System.out.println("3. Rotate");
		System.out.println("4. Print size of list");
		System.out.println("5. Exit");		
		
		choice = console.readInt();
		
		if (choice == 1)
		{
			System.out.print("Enter item: ");
			item = console.readWord();
			list.add(item);
		}
		if (choice == 2)
		{
			System.out.println(list);
		}

		if (choice == 3)
		{
			list.rotate();
		}

		if (choice == 4)
		{
			System.out.println("Size: " + list.size() );
		}
								
								
		}
		while (choice != 5);
		

}		
}
		
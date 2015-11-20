import java.util.*;
public class MyTreeSet
{
	private TreeNode root;
	private int size;
	
	public MyTreeSet()
	{
		root = null;
		size = 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean contains(Object item)
	{
		return containsHelper(root,item);
	}
	
	public boolean containsHelper(TreeNode t, Object item)
	{
		Comparable temp = (Comparable)item;
		
		if(t == null)
		{
			return false;
		}
		else
			{
				Comparable value = (Comparable)t.getValue();
				if(t.getValue().equals(temp))
				{
					return true;
				}
				
				if(value.compareTo(temp) < 0)
				{
					return containsHelper(t.getRight(), item);
				
				}
					
				if(value.compareTo(temp) > 0)
				{
					return containsHelper(t.getLeft(),item);
				}
				
			}
			
			return false;
						
	}
	
	public boolean add(Object item)
	{
		if(this.contains(item))
		{
			return false;
		}
		else
			{
				root = addHelper(root,item);
				size = size() + 1;
				return true;
			}
	}
		
	public TreeNode addHelper(TreeNode t, Object item)
	{
		Comparable temp = (Comparable) item;
		
		if(t == null)
		{
			return new TreeNode(item,null,null);
		}
		else
			{
				Comparable value = (Comparable) t.getValue();
				if(value.compareTo(temp) > 0)
				{
					t.setLeft(addHelper( t.getLeft(), item));
				}
				else
					{
						t.setRight(addHelper( t.getRight(), item));
					}
			}
			
			return t;
							
	}
	public String toString()
	{
		return "[" + toStringHelper(root).substring(0,toStringHelper(root).length()-1) + "]";
	}
	
	public String toStringHelper(TreeNode t)
	{
		String str = "";
		if(t == null)
		{
			return "";
		}
		else
			{
		
				 str = str + toStringHelper(t.getLeft()) +  t.getValue() + ","  + toStringHelper(t.getRight());
			}
			
		
			return str;


	}
				
		
	
	
	public static void main(String[] args)
	{
		EasyReader console = new EasyReader();
		MyTreeSet tree = new MyTreeSet();
		
		String item = "";
		while (!item.equals("end"))
		{
			System.out.print("Enter item to insert(end to exit): ");

			item = console.readWord();
			if (!item.equals("end"))
			{
				if ( !tree.add(item) ) System.out.println("not added, already in set");
				System.out.println(tree);
				System.out.println("Size: " + tree.size);	
			}
			
		}
		item = "";
			
			//System.out.println(tree);

				System.out.println(tree);
				System.out.println("Size: " + tree.size);
				
				System.out.println("");                    
		
			//for(Object obj : hs)
		//	System.out.print(obj);


		/*while (!item.equals("end"))
		{
			System.out.print("Enter item to remove(end to exit): ");

			item = console.readWord();
			if (!item.equals("end"))
			{
				if ( !tree.remove(item) ) System.out.println("not in set");
				System.out.println(tree);
			}	
		}*/
		
	}
		
			
	
}
	
		
		
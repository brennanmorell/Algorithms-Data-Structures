import java.util.*;
import cs1.*;
public class Heap
{
  private static final int DFLT_CAPACITY = 1024;
  private Object items[];
  private int numItems;

  public Heap()
  {
    this(DFLT_CAPACITY);
  }


  public Heap(int initialCapacity)
  {
    items = new Object[initialCapacity + 1];
  }


  public boolean isEmpty()
  {
    return numItems == 0;
  }

  public Object peek()
  {
    if (numItems == 0)
    {
      throw new NoSuchElementException();
    }

    return items[1];
  }

  public Object remove()
  {
    if (numItems == 0)
    {
      throw new NoSuchElementException();
    }

    Object min = items[1];
    items[1] = items[numItems];
    numItems--;
    reheapDown();
    return min;
  }

  public void add(Object obj)
  {
    numItems++;
    if (numItems >= items.length)
      doubleCapacity();
    items[numItems] = obj;
    reheapUp();
  }

  private boolean lessThan(Object obj1, Object obj2)
  {
      return ((Comparable)obj1).compareTo(obj2) < 0;
  }

  private void reheapDown()
  {
    Object root = items[1];  // save root
    int iParent = 1, iChild = 2;

    while (iChild <= numItems)
    {
      if (iChild < numItems && lessThan(items[iChild+1], items[iChild]))
        iChild++;  // set iChild to the smaller right child
      if (!lessThan(items[iChild], root))
        break;
      items[iParent] = items[iChild];
      iParent = iChild;
      iChild = 2 * iParent; // left child
    }
    items[iParent] = root;
  }

  private void reheapUp()
  {
    Object temp = items[numItems];  // save new leaf
    int iChild = numItems, iParent = iChild / 2;

    while (iParent >= 1 && lessThan(temp, items[iParent]))
    {
      items[iChild] = items[iParent];
      iChild = iParent;
      iParent = iChild / 2;
    }
    items[iChild] = temp;
  }
  
  public static void HeapSort (double[] numbers)
  {
		Heap h = new Heap(numbers.length);
		for( int i = 0; i < numbers.length; i++)
		{
			h.add(numbers[i]);
		}
		
		for(int i = 0; i < numbers.length; i++)
		{
			System.out.println(h.remove());		
		}
  }

 

// insert numbers into a heap

 

// repeatedly remove min value

  private void doubleCapacity()
  {
    Object tempItems[] = new Object[2 * items.length - 1];
    for (int i = 0; i <= numItems; i++)
      tempItems[i] = items[i];
    items = tempItems;
  }
  
  
public TreeNode convertHeapToTree()
{
	return convertHeapToTreeHelper(1);
}  

private TreeNode convertHeapToTreeHelper(int loc)
{
	TreeNode t = new TreeNode(items[loc],null,null);
	if(loc > numItems)
	{
		return null;
	}
	else
		{
			
			
			return new TreeNode(items[loc], convertHeapToTreeHelper(2*loc), convertHeapToTreeHelper((2*loc) + 1));
		}
		
}

public String toString()
{
	String print = "";
	
	for(int i = 1; i < numItems+1; i++)
	{
		print+=items[i];
	}
	
	return print;
	
}
		
	
	public static void main(String args[]) {
		
		double [] nums = new double[7];
		//Heap h = new Heap();
		for (int i = 0; i < 7; i++) 
		{
// *** code to enter values from keyboard			
			//Double num = Keyboard.readDouble();

			//h.add(num);
			nums[i] = (double)(Math.random() * 10);  
		}
		//System.out.println("The Heap (Items) : " + h);
		//System.out.println();
		//TreeNode t = h.convertHeapToTree();
		//Tree tre = new Tree(t);
		
		
		//tre.PrintTree();
		HeapSort(nums);  
		
		
}				

}


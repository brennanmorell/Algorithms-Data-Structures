/*
    This class implements a simple version 
    of the heapsort algorithm.
 
    The implementation is based on a sorting
    framework by Cay Horstmann.
 
    @author J. Mohr
 */
 public class HeapSort
 {
    private double[] a;

    public HeapSort(double[] anArray)
    {
       a = anArray;
    }
 
    /**
       Sorts the array managed by this sorter
    */
    public void sort()
    {
       sort( a.length - 1 );
    }
 
    public void sort( int end )
    {
       // Establish the heap property.
       for ( int i = end / 2; i >= 0; i-- )
          fixHeap( i, end, a[i] );
       
       // Now place the largest element last,
       // 2nd largest 2nd last, etc.
       for ( int i = end; i > 0; i-- )
       {
          // a[0] is the next-biggest element.
          swap( 0, i );
 
          // Heap shrinks by 1 element.
          fixHeap( 0, i - 1, a[0] );
       }
    }
 
    /**
       Assuming that the partial order tree
       property holds for all descendants of
       the element at the root, make the
       property hold for the root also.
 
       @param root the index of the root
                     of the current subtree
       @param end  the highest index of the heap
    */
    private void fixHeap( int root, int end,
                          double key )
    {
       int child = 2 * root; // left child
       
       // Find the larger child.
       if ( child < end && a[child] < a[child + 1] )
          child++;  // right child is larger
 
       // If the larger child is larger than the
       // element at the root, move the larger child
       // to the root and filter the former root 
       // element down into the "larger" subtree.
       if ( child <= end && key < a[child] )
       {
          a[root] = a[child];
          fixHeap( child, end, key );
       }
       else
          a[root] = key;
    }
 
    /**
       Swaps two entries of the array.
       @param i the first position to swap
       @param j the second position to swap
    */
    private void swap(int i, int j)
    {
       double temp = a[i];
       a[i] = a[j];
       a[j] = temp;
    }
 
   public String toString()
   {
   		String retVal = "";
   		for(int i = 0; i<a.length;i++)
   			retVal += a[i]+"  ";
   		retVal+="\n";
   		
   		return retVal;	
   }	
   public static void main(String[] args)
   {
   		double[] nums = {6, 1, 7, 3, 8, 9, 4, 5, 2};
   		HeapSort hs = new HeapSort(nums);
   		System.out.println(hs);
		hs.sort();
		System.out.println(hs);
   		
   }

 }


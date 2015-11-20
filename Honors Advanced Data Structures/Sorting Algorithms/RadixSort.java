import java.util.*;

public class RadixSort
{
	private Queue[] QA;
	
	public RadixSort()
	{
		QA = new Queue[10];
		for(int i = 0;i < 10; i++)
			QA[i] = new LinkedList();// instantiate things here

	}
	
	public int getDigit(int num, int k)
	{
		
			
		int temp = num / (int)(Math.pow(10,k)) % 10;
		
		//System.out.print("Num = " + num + " K = " + k + " temp = " + temp);
		
		
		return temp;
				// returns kth digit - ones place is considered digit 0
		
	}
	
	private void fillTheQueues(int[] nums, int dig)
	{
		// dig is an integer indicating which digit is currently being used: 0 is the ones place
		// based on the value of that digit for each value in nums, the numbers will be placed into
		// the appropriate queue
		for(int i = 0; i < nums.length; i++)
		{
			int digitVal = getDigit(nums[i], dig);
			QA[digitVal].add(nums[i]);
		}

	}
	
	private void fillTheArray(int[] nums)
	{
		int indy = 0;
		for(int i = 0; i < QA.length; i++)
		{
			while(!QA[i].isEmpty())
			{
				nums[indy] = (Integer)QA[i].remove();
				indy++;
			}
		}// traverses the array of queues, empties each queue into nums
	}				
	
		
	public void doTheSort(int[] theList, int numDig)
	{
		for(int num = 0; num < numDig; num++)
		{
			fillTheQueues(theList, num);
			fillTheArray(theList);
		}//numDig is the largest number of digits present in theList
		// this method should invoke fillTheQueues and fillTheArray until the list is sorted		
		
	}

	public static void main(String[] args)
	{
		int[] vals = {49,32,21,11,18,66,111};
			
		
		RadixSort sorter = new RadixSort();
		
		sorter.doTheSort(vals, 3);
		
		/*TESTING FOR GET DIGITS*/ //System.out.print("here" + sorter.getDigit(11,1));
		
		for (int i = 0; i < vals.length; i++)
			System.out.println(vals[i]); // should be sorted
	}
}			

				
			
		
		
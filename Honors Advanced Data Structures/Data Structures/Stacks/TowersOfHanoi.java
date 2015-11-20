//********************************************************************
//  TowersOfHanoi.java       
//
//  Represents the classic Towers of Hanoi puzzle.
//********************************************************************

public class TowersOfHanoi
{
   private int totalDisks;

   //-----------------------------------------------------------------
   //  Sets up the puzzle with the specified number of disks.
   //-----------------------------------------------------------------
   public TowersOfHanoi (int disks)
   {
      totalDisks = disks;
   }

   //-----------------------------------------------------------------
   //  Performs the initial call to moveTower to solve the puzzle.
   //  Moves the disks from tower 1 to tower 3 using tower 2.
   //-----------------------------------------------------------------
   public int solve ()
   {  
      return moveTower (totalDisks, 1, 3);
   }
   
   private int moveTower(int totalDisks, int start, int end)
   {
   		int spare = 6-start-end;
   		int count = 0;
   		if(totalDisks == 0)
   		{
   			return 0;
   		}
   		else
   			{
   				count+= 1 + moveTower(totalDisks-1,start,spare);
   				System.out.println(start + "-->" + end);
   				count+=moveTower(totalDisks-1,spare,end);
   			}
   		
   			return count;
   			
   		
   			
   }	
   
   //-----------------------------------------------------------------
   //  Moves the specified number of disks from one tower to another
   //  by moving a subtower of n-1 disks out of the way, moving one
   //  disk, then moving the subtower back. Base case of 0 disks.
   //-----------------------------------------------------------------

//your code here




    public static void main (String[] args)
   {
      TowersOfHanoi towers = new TowersOfHanoi (3);

      System.out.println(towers.solve() +" moves.");
   }

}

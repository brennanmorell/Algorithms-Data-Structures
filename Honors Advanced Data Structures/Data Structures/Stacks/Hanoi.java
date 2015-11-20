import cs1.*;
import java.util.*;
public class Hanoi
{
	public static void main(String args[])
	{
		Stack peg1 = new Stack<Integer>();
		Stack peg2 = new Stack<Integer>();
		Stack peg3 = new Stack<Integer>();
		
		System.out.println("How many rings?");
		int ringNum = Keyboard.readInt();
		
		for(int i = ringNum; i > 0; i--)
		{
			peg1.push(i);
		}
		
		System.out.println(peg1);
		
	}
}
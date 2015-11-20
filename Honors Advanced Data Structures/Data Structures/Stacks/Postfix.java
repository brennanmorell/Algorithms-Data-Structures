import java.util.*;
import cs1.*;


public class Postfix
{
	

	
	public static void main(String[] args)
	{
		System.out.print("Enter infix: ");
		String infix = Keyboard.readString();
		
		String result = generatePostfix(infix);
		System.out.println(result);
	}
	
	public static String generatePostfix(String infix)
	{
		
		Stack<String> postStack = new Stack<String>();
		String postfix = "";
		String operators = "+-*/";
		String opener = "(";
		String closer = ")";
		
		for(int i = 0; i < infix.length(); i++) // Loop through the infix string
		{
			/*System.out.println("postfix: " + postfix);
			System.out.println("stack : " + postStack);*/
			String processPart = infix.substring(i,i+1);
			/*System.out.println("processPart : " + processPart);
			System.out.println();*/
			
			if(processPart.equals(opener))
			{
				postStack.push(processPart);
		
			}
			
			else	
			
				{
					if(operators.indexOf(processPart) == -1 && !(processPart.equals(closer)) && !(processPart.equals(opener))) //If the character is an operand, append it to the postfix string
					{
						postfix+= processPart;
			
					}
				
					else
				
						if(operators.indexOf(processPart) != -1) //If the character is an operator
						{
							if(postStack.isEmpty())
							{
								postStack.push(processPart);
							}
						
					
							else
								{	
									String temp = postStack.peek();
								
					
					
									while(!postStack.isEmpty() &&  !(temp.equals(opener)) && precedence(processPart, temp) == 1)// You need to pop and append ALL operators that are above the most recent opening parentheses AND that have precedence higher than or equal to the operator that you are processing
									{
							
										String temp2 = postStack.pop();
										postfix+= temp2;
										if(!postStack.isEmpty())
											temp = postStack.peek();
									}
							
									postStack.push(processPart);//push the operator onto the stack
								}
						}
				
				
								if(processPart.equals(closer))//Closing parentheses cause all operators above the most recent opening parentheses must be popped and appended to the postfix string.  Pop and discard the opening parentheses.
								{
									
						  			while(!postStack.isEmpty() && !(postStack.peek().equals(opener)))
						  			{
						  				String temp = postStack.pop();
						  				if(!(temp.equals(opener)))
						  				{
						  					postfix+=temp; 
						  				}
						  			
						    		}
						  	
						  			if(!postStack.isEmpty())
						  				postStack.pop();//pop and discard opening parentheses
						  
								}
			}
		
		}
		
		if(!postStack.isEmpty()) //if the stack still has operators in the end
		{
			while(!postStack.isEmpty())
			{
				String temp2 = postStack.pop();
				postfix+= temp2;
			}
		}
					
			
			
			
			
		System.out.println(postfix);
		return postfix;
	}
	
	public static int precedence(String processPart, String temp)
	{
		String multDiv = "*/";
		String addSub = "+-";
		
		boolean isPrecedingPart = false;
		boolean isPrecedingTemp = false;
		
		
		if(multDiv.indexOf(processPart) != -1)
		{
			isPrecedingPart = true;
		}
		
		if(multDiv.indexOf(temp) != -1)
		{
			isPrecedingTemp = true;
		}
		
		if(isPrecedingPart && !isPrecedingTemp)
		{
			return 0;
		}
		
		if(isPrecedingTemp && !isPrecedingPart)
		{
			return 1;
		}
		
		if(isPrecedingTemp && isPrecedingPart)
		{
			return 1;
		}
		
		if(!isPrecedingPart && !isPrecedingTemp)
		{
			return 1;
		}
		
		else
		
			return -1;
	
	}
}
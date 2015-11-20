import java.util.*;
import cs1.*;


public class EvalInfix
{
	private  ArrayList<Integer>vals;
	private ArrayList<String>vars;
	private  String postfix;
	private  String operators;
	private  String opener;
	private String closer;

	
	
	
	public EvalInfix()
	{
		vals = new ArrayList<Integer>();
		vars = new ArrayList<String>();
		operators = "+-*/";
		opener = "(";
		closer = ")";
		
		System.out.print("Enter Infix: ");
		String infix = Keyboard.readString();
		Postfix obj = new Postfix();
		postfix = obj.generatePostfix(infix);
		System.out.println(postfix);
		
	
		
			for(int i = 0; i < postfix.length(); i++)
			{
				boolean alreadyInputed = false;
				String temp = postfix.substring(i,i+1);
				if(operators.indexOf(temp) == -1 && !(temp.equals(opener)) && !(temp.equals(closer)))
				{
					for(int k = 0; k < vars.size(); k++)
					{
						if(vars.get(k).equals(temp))
						{
							alreadyInputed = true;
						}
					}
						
					if(!alreadyInputed)
					{
						vars.add(temp);
						System.out.println("Enter a value for " + temp + ": ");
						int num = Keyboard.readInt();
						vals.add(num);
					}
				}
			}
	
		
	}
		
	public static void main(String[] args)
	{
		
		EvalInfix a = new EvalInfix();

		System.out.println("      " + a.doInfix() + "        ");
		
	}
	
	public int doInfix()
	{
		int total = 0;
		int num = 0;
		boolean found = false;
		Stack<Integer> inStack = new Stack<Integer>();
		for(int i = 0; i < postfix.length(); i++)
		{
			String temp = postfix.substring(i,i+1);
			System.out.print(temp);
		
			
			if(operators.indexOf(temp) == -1 && !(temp.equals(opener)) && !(temp.equals(closer))) //if its an operand, push it
			{
				for(int k = 0; k < vars.size(); k++)
				{
					if(vars.get(k).equals(temp))
					{
						num = k;
						found = true;
					}
				}
				
				if(found)	
					inStack.push(vals.get(num));
			}
			
			else
				
			  	if(operators.indexOf(temp) != -1)
			  	{
			  		int value = 0;
			  		int a = 0;
			  		int b = 0;
			  			
			  		if(!(inStack.isEmpty()))
			  		{
			  			a = inStack.pop();
			  			
			  			if(!(inStack.isEmpty()))
			  			{
			  				b = inStack.pop();
			  			}
			  		
			  			if(temp.equals("+"))
			  				value = a + b;
			  			if(temp.equals("-"))
			  				value = b - a;
			  			if(temp.equals("*"))
			  				value = a*b;
			  			if(temp.equals("/"))
			  				value = b/a;
			  			
			  			inStack.push(value);
			  		}
			  }	
			  			
		}
		
		return inStack.pop();
	}
			  				
}
				
				 	
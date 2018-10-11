package projectCode.stringcalculator;

import java.util.Stack; 
  
public class SimpleCalculator 
{ 
    public static int calculate(String expression) 
    { 
        char[] tokens = expression.toCharArray(); 
  

        Stack<Integer> values = new Stack<Integer>(); 
  
    
        Stack<Character> ops = new Stack<Character>(); 
  
        for (int i = 0; i < tokens.length; i++) 
        { 
            
            if (tokens[i] == ' ') 
                continue; 
  
            if (tokens[i] >= '0' && tokens[i] <= '9') 
            { 
                StringBuffer sbuf = new StringBuffer(); 
                
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
                    sbuf.append(tokens[i++]); 
                values.push(Integer.parseInt(sbuf.toString())); 
            } 
  
            
            else if (tokens[i] == '(') 
                ops.push(tokens[i]); 
  
            
            else if (tokens[i] == ')') 
            { 
                while (ops.peek() != '(') 
                  values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
                ops.pop(); 
            } 
  
            // Current token is an operator. 
            else if (tokens[i] == '+' || tokens[i] == '-' || 
                     tokens[i] == '*' || tokens[i] == '/') 
            { 
                
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) 
                  values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
  
               
                ops.push(tokens[i]); 
            } 
        } 
  
        while (!ops.empty()) 
            values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
  
        // Top of 'values' contains result, return the value
        return values.pop(); 
    } 
  
 
    public static boolean hasPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    } 
  
    // method to apply an operator 'op' on operands 'a' and 'b'. Return the result. 
    public static int applyOp(char op, int b, int a) 
    { 
        switch (op) 
        { 
        case '+': 
            return a + b; 
        case '-': 
            return a - b; 
        case '*': 
            return a * b; 
        case '/': 
            if (b == 0) 
                throw new
                UnsupportedOperationException("Cannot divide by zero"); 
            return a / b; 
        case '^': 
    		return a ^ b;
        } 
        return 0; 
    	 
    } 
  
    // Driver method to test above methods 
    public static void main(String[] args) 
    { 
        System.out.println(SimpleCalculator.calculate("7+6*52+3-4/2")); 
        System.out.println(SimpleCalculator.calculate("100 * 2 + 12")); 
        System.out.println(SimpleCalculator.calculate("100 * ( 2 + 12 )")); 
        System.out.println(SimpleCalculator.calculate("100 * ( 2 + 12 ) / 14")); 
    } 
}
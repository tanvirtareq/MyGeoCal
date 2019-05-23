/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocal;

import java.util.*;

/**
 *
 * @author Tanvir Tareq
 */
public class MathHelper {
    
    public static void main(String[] args) {
        infixToPostfix("asdfg");
    }
    
    public static  String infixToPostfix(String infix)
    {
        String postfix="";
        
        Stack<Character> stk=new Stack<Character>();
        stk.push('(');
        
        infix=infix+')';
        
        boolean isNumberStart=false;
       
        for(int i=0;i<infix.length();i++)
        {
            if(infix.charAt(i)<='0' && infix.charAt(i)>='9')
            {
                if(isNumberStart==false)
                {
                    isNumberStart=true;
                    postfix = postfix.concat("@");
                    postfix=postfix+infix.charAt(i);
                }
                
                else {
                     postfix=postfix+infix.charAt(i);
                    
                }
                
            }
            
            else
            {
                if(isNumberStart==true)
                {
                    isNumberStart=false;
                    postfix = postfix.concat("#");
                    
                }
                
                if(infix.charAt(i)=='L' || infix.charAt(i)=='S' || infix.charAt(i)=='(')
                {
                    stk.push(infix.charAt(i));
                }
                
           
                
                else if(infix.charAt(i)==')')
                {
                    while(stk.peek()!='(' || stk.peek()!='L' || stk.peek()!='S')
                    {
                        postfix=postfix+stk.peek();
                        stk.pop();
                    }
                    stk.pop();
                }
                
                else
                {
                    while(prec(infix.charAt(i))<=prec(stk.peek()))
                    {
                        postfix=postfix+stk.peek();
                        stk.pop();
                    }
                    stk.push(infix.charAt(i));
                    
                }
                
            }
            
        }
        
       
        return postfix;
    }
    
    static double changedX(double x1,double X,double unitOfScale){
        return (X+x1*unitOfScale);
    }
     static double changedY(double x1,double X,double unitOfScale){
        return (X-x1*unitOfScale);
    }

    private static int prec(char charAt) {
        
        if(charAt=='+' || charAt=='-') return 1;
        if(charAt=='/' || charAt=='*') return 2;
        
        return 3;
        
    }
    
  

    static double postfixToEvaluate(String func, double x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    
}

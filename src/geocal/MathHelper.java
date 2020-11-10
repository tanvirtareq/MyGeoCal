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
            if((infix.charAt(i)<='0' && infix.charAt(i)>='9') || infix.charAt(i)=='x')
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
                    
                    if(stk.peek()!='(')
                    {
                        postfix=postfix+stk.peek();
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
    
  

    static double postfixToEvaluate(String postfix, Double x) {
        double ans=0;
        
        Stack<Character> stk=new Stack<>();
        Stack<Double> numberStk=new Stack<>();
        
//        stk.add('(');
        
//        postfix=postfix+")";
         String str="";
          boolean intStart=false;
        
        for(int i=0;i<postfix.length();i++)
        {
           if(postfix.charAt(i)=='@')
           {
               intStart=true;
               str="";
               i++;
               while(postfix.charAt(i)!='#')
               {
                   if(postfix.charAt(i)=='x')
                   {
                       str=str+x.toString();
                   }
                   else
                   {
                       str=str+postfix.charAt(i);
                   }
                   i++;
               }
               Double nmbr=Double.parseDouble(str);
               numberStk.push(nmbr);
           }
           
           else if(postfix.charAt(i)=='+')
           {
               Double b=numberStk.peek();
               numberStk.pop();
               
               Double a=numberStk.peek();
               numberStk.pop();
               
               Double answer=a+b;
               numberStk.push(answer);
           }
           
           else if(postfix.charAt(i)=='-')
           {
               Double b=numberStk.peek();
               numberStk.pop();
               
               Double a=numberStk.peek();
               numberStk.pop();
               
               Double answer=a-b;
               numberStk.push(answer);
           }
           
           else if(postfix.charAt(i)=='*')
           {
               Double b=numberStk.peek();
               numberStk.pop();
               
               Double a=numberStk.peek();
               numberStk.pop();
               
               Double answer=a*b;
               numberStk.push(answer);
           }
           
           else if(postfix.charAt(i)=='/')
           {
               Double b=numberStk.peek();
               numberStk.pop();
               
               Double a=numberStk.peek();
               numberStk.pop();
               
               Double answer=a/b;
               numberStk.push(answer);
           }
           
           else if(postfix.charAt(i)=='L')
           {
               Double a=numberStk.peek();
               numberStk.pop();
               
               Double answer=Math.log10(a);
               numberStk.push(answer);
           }
           
           else if(postfix.charAt(i)=='S')
           {
               Double a=numberStk.peek();
               numberStk.pop();
               
               Double answer=Math.sin(a);
               numberStk.push(answer);
           }
            
        }
        
        return numberStk.peek();
    }
    
}

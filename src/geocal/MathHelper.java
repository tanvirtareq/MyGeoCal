/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocal;

import java.util.Stack;

/**
 *
 * @author Tanvir Tareq
 */
public class MathHelper {
    
    public static void main(String[] args) {
        infixToPostfix("asdfg");
    }
    
    public static  String infixToPostfix(String str)
    {
        String postfix=null;
        
        char[] stk=new char[10000];
        int top=0;
        stk[top]='(';
        top++;
        
        while(top>=0)
        {
            
            
        }

        
        return postfix;
    }
    
}

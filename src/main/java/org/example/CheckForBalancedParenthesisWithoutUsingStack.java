package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CheckForBalancedParenthesisWithoutUsingStack {
    static char findClosing(char c){
        if(c=='('){
            return ')';
        }else if(c=='{'){
            return '}';
        }else if(c=='['){
            return ']';
        }
        return Character.MIN_VALUE;
    }
    public static boolean check(char[] ch,int n){
        if(n==0){
            return true;
        }else if(n==1){
            return false;
        }else if(ch[0]==')' || ch[0]=='}'||ch[0]==']'){
            return false;
        }

        char closing = findClosing(ch[0]);
        int i, count =0;
        for(i=1;i<n;i++){
            if(ch[i]==ch[0])
                count++;
            if(ch[i]==closing){
                if(count==0){
                    break;
                }
                count--;
            }
        }

        if(i==n){
            return false;
        }
        if(i==1)
            return check(Arrays.copyOfRange(ch,i+1,n),n-2);

        return check(Arrays.copyOfRange(ch,1,i),i-1) && check(Arrays.copyOfRange(ch,(i+1),n),n-1-i);
    }
    public static void main(String[] args) {
        String s = "((()))";
        if(check(s.toCharArray(),s.length())){
            System.out.println("balanced parenthesis");
        }else{
            System.out.println("un-balanced parenthesis");
        }
    }
}

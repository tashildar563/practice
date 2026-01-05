package org.example;

public class PrinttheKthDigit implements Solution {
    @Override
    public void logic() {
        int a=2;
        int b=10;
        int k=3;
        double n= (Double)Math.pow(a,b);
        System.out.println("a^b : "+n);
        int rem;
        while(k>0){
            rem=(int) n%10;
            k--;
            if(k==0){
                System.out.println("kth ("+k+") digit : "+rem);
            }
            n=n/10;
        }
    }

    @Override
    public String description() {
        return "7. Print the Kth Digit";
    }

    @Override
    public String problemStatement() {
        return "Given two numbers a and b, find kth digit from right of ab.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: a = 3, b = 3, k = 1\n" +
                "Output: 7\n" +
                "Explanation: 33 = 27 and 1st digit from right is 7";
    }
}

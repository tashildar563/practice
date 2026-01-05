package org.example;

public class ClosentNumber implements Solution {

    @Override
    public void logic() {
        System.out.println("================================="+description()+"START=================================");
        int n = -16;
        boolean negative = false;
        if(n<0){
            negative = true;
        }
        int absN = Math.abs(n);
        int m = 6;
        int div = absN/m;
        int a1 = m*div;
        int a2 = m*(Math.abs(div)+1);
        int diff = Math.abs(absN-a1);
        int diff2 = Math.abs(absN-a2);
        if(diff>diff2){
            System.out.println("Closest Number :"+(negative?a2*-1:a2));
        }else if(diff==diff2){
            System.out.println("Closest Number :"+(negative?a1*-1:a1) + " and "+ (negative?a2*-1:a2));
        }else{
            System.out.println("Closest Number :"+(negative?a1*-1:a1));
        }
    }

    @Override
    public String description() {
        return "4. Closest Number";
    }

    @Override
    public String problemStatement() {
        String s = "Given two integers n and m (m != 0). The problem is to find the number closest to n and divisible by m. If there is more than one such number, then output the one having the maximum absolute value.\n" +
                "\n" +
                "Examples :\n" +
                "\n" +
                "Input: n = 13, m = 4\n" +
                "Output: 12\n" +
                "Explanation: 12 is the Closest Number to 13 which is divisible by 4.\n" +
                "Input: n = -15, m = 6\n" +
                "Output: -18\n" +
                "Explanation: Both -12 and -18 are closest to -15 and divisible by 6, but -18 has the maximum absolute value. So, output is -18.\n" +
                "Constraints:\n" +
                "-105 ≤ n, m ≤ 105";
        return s;
    }
}

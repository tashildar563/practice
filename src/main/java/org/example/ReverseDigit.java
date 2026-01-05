package org.example;

public class ReverseDigit implements Solution {
    @Override
    public void logic() {
        System.out.println(problemStatement());
        int digit = 3457889;
        int div,rem;
        int rev =0;
        while (digit>0){
            rem = digit%10;
            rev = (rev*10)+rem;
            digit=digit/10;
        }
        System.out.println();
        System.out.println("==================================");
        System.out.println("Reverse digit : "+rev);
    }

    @Override
    public String description() {
        return "6. Reverse The Digit";
    }

    @Override
    public String problemStatement() {
        return "You are given an integer n. Your task is to reverse the digits, ensuring that the reversed number has no leading zeroes.\n" +
                "\n" +
                "Examples:\n" +
                "\n" +
                "Input: n = 122\n" +
                "Output: 221\n" +
                "Explanation: By reversing the digits of number, number will change into 221.";
    }
}

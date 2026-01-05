package org.example;

public class ArmstrongNumbers implements Solution {
    @Override
    public void logic() {
        int n = 372;
        int div = n/10;
        int rem = n % 10;
        int sum = 0;
        while (rem > 0) {
            sum = sum+cube(rem);
            rem=div%10;
            div =div/10;
        }
        if(sum == n){
            System.out.println("Armstrong Number : "+sum);
        }else {
            System.out.println("Not an Armstrong Number : "+sum);
        }
    }
    public int cube(int i){
        return i*i*i;
    }

    @Override
    public String description() {
        return "5. Armstrong Numbers";
    }

    @Override
    public String problemStatement() {
        return "You are given a 3-digit number n, Find whether it is an Armstrong number or not.\n" +
                "\n" +
                "An Armstrong number of three digits is a number such that the sum of the cubes of its digits is equal to the number itself. 371 is an Armstrong number since 33 + 73 + 13 = 371. \n" +
                "\n" +
                "Examples:\n" +
                "\n" +
                "Input: n = 153\n" +
                "Output: true\n" +
                "Explanation: 153 is an Armstrong number since 1^3 + 5^3 + 3^3 = 153. ";
    }
}

package org.example;

public class BinaryNumbertoDecimalNumber implements Solution {
    @Override
    public void logic() {
        int binaryNum=100001;
        int decimalNumber = 0;
        int position=0;
        while(binaryNum>0){
            int rem = binaryNum%10;
            decimalNumber = decimalNumber + (rem > 0 ? printDecimalNumber(position):0);
            position++;
            binaryNum = binaryNum/10;
        }
        System.out.println("Decimal Number "+decimalNumber);
    }

    private int printDecimalNumber(int position) {
        return (int) Math.pow(2,position);
    }

    @Override
    public String description() {
        return "8. Binary number to decimal number";
    }

    @Override
    public String problemStatement() {
        return "===========================================================\n" +
                "Given a string b representing a Binary Number, The problem is to find its decimal equivalent.\n" +
                "\n" +
                "Examples:\n" +
                "\n" +
                "Input : b = 111\n" +
                "Output : 7\n" +
                "Explanation : The decimal equivalent of the binary number 111 is 22 + 21 + 20 = 7." +
                "\n===========================================================";
    }
}

package org.example;

import java.util.ArrayList;
import java.util.List;

public class DecimalNumberToBinaryNumber implements Solution {
    @Override
    public void logic() {
        int dec = 103;
        List<Integer> binaryNumber = new ArrayList<>();
        getBinaryNumber(dec,binaryNumber);
        String bn = "";
        for(int i=0;i<binaryNumber.size();i++){
            bn = bn + binaryNumber.get(binaryNumber.size() - 1 - i);
        }
        System.out.println(bn);
    }

    private void getBinaryNumber(int dec, List<Integer> binaryNumber) {
        Integer quetient = dec/2;
        Integer rem = dec%2;
        binaryNumber.add(rem);
        if(quetient>0){
            getBinaryNumber(quetient, binaryNumber);
        }
    }

    @Override
    public String description() {
        return "9. Decimal To Binary";
    }

    @Override
    public String problemStatement() {
        return "";
    }
}

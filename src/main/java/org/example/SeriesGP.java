package org.example;

public class SeriesGP implements Solution {
    @Override
    public void logic() {
        System.out.println("================================="+description()+"START=================================");
        int a=2, r=2;
        int nthterm = 10;
        for(int i=0;i<nthterm;i++){
            System.out.println((a*(Math.pow(r,i)))+", ");
        }
        System.out.println("================================="+description()+"END=================================");
    }

    @Override
    public String description() {
        return "3. Geometric Progression : ";
    }

    @Override
    public String problemStatement() {
        return "";
    }
}

package org.example;

public class SeriesAP implements Solution {
    @Override
    public void logic() {
        System.out.println("================================="+description()+"START=================================");
        int a1=2, a2=4;
        int diff = a2-a1;
        int nthterm = 4;
        for(int i=0;i<nthterm;i++){
            System.out.println((a1+(diff*i))+", ");
        }
        System.out.println("================================="+description()+"END=================================");
    }

    @Override
    public String description() {
        return "2. Arithmetic Progression : ";
    }

    @Override
    public String problemStatement() {
        return "";
    }
}

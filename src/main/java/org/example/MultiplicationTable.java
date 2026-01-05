package org.example;

public class MultiplicationTable implements Solution{
    @Override
    public void logic() {
        System.out.println("============================"+description()+"START=====================================");
        int n = 9;
        int i =1;
        while(i<=10){
            System.out.println(n*i);
            i++;
        }
        System.out.println("=========================="+description()+"END=====================================");

    }

    @Override
    public String description() {
        return "1. Multiplication Table : ";
    }

    @Override
    public String problemStatement() {
        return "";
    }
}

package org.example;

import java.util.*;

public class KdiffPairsinanArray {
    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        int k =2;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int x:nums){
            cnt.put(x,cnt.getOrDefault(x,0)+1);
        }
        int res=0;
        for(int x:cnt.keySet()){
            if(k > 0 && cnt.containsKey(x+k) || (k==0 && cnt.get(x)>1)){
                res++;
            }
        }
        System.out.println("count : "+res);
    }
}

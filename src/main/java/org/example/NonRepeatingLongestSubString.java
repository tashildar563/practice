package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NonRepeatingLongestSubString {
    public static void main(String[] args) {
        String s = "rakesh";
        int l=0;
        int ml=0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                ml = Math.max(ml,i-l+1);
            }else{
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(i));
                    l++;
                }
                set.add(s.charAt(i));
            }
        }
        System.out.println("Length of longest substring without repreating char "+ml);
    }
}

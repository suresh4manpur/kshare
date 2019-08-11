package com.skill.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PowerSetString {

    // str : Stores input string  
    // curr : Stores current subset  
    // index : Index in current subset, curr  
    static void powerSet(String str, int index, 
                            String curr)  
    { 
        int n = str.length(); 
  
        // base case  
        if (index == n) 
        { 
            return; 
        } 
  
        // First print current subset  
        System.out.println(curr); 
  
        // Try appending remaining characters  
        // to current subset  
        for (int i = index + 1; i < n; i++)  
        { 
            curr += str.charAt(i); 
            powerSet(str, i, curr); 
  
            // Once all subsets beginning with  
            // initial "curr" are printed, remove  
            // last character to consider a different  
            // prefix of subsets.  
            System.out.println("curr before: "+curr);
            curr = curr.substring(0, curr.length() - 1); 
            System.out.println("curr after: "+curr);

        } 
    } 
    
    public static List<String> getPerms(String binInput, int index){
        List<String> allsubsets;
        if(binInput.length() == index){
            allsubsets = new ArrayList<String>();
            allsubsets.add("");
        }else{
            allsubsets = getPerms(binInput, index+1);
            char val = binInput.charAt(index);
            List<String> nextSubsets = new ArrayList<>();

            for(String subset : allsubsets){
            StringBuilder sb = new StringBuilder();
            sb.append(subset);
            sb.append(val);
            nextSubsets.add(sb.toString());
            }
            allsubsets.addAll(nextSubsets);
        }
        return allsubsets;
    }
  
    // Driver code  
    public static void main(String[] args)  
    { 
/*        String str = "abcd"; 
        int index = -1; 
        String curr = ""; 
        powerSet(str, index, curr); */
    	
    	List<String> results = getPerms("abcd", 0);
    	for(String val : results){
    		System.out.println(val);
    	}
    } 
}

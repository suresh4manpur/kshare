package com.kshare.atest;

public class MyTest {
    public static void main(String[] args) {
    	
    	String a = "a";
    	System.out.println(a.substring(0,1));
    	System.out.println(a.substring(1,0));
    	
    	String b = "ab";
    	System.out.println(b.substring(0,1));
    	System.out.println(b.substring(1,2));
    	
    	//m1(null );

    }
    public static void m1(String name){
    	System.out.println("m1 string");
    }
    public static void m(Object obj){
    	System.out.println("m1 obj");
    }

}


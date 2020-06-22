package com.string;

public class RotateArrayBy2 {
	public static void main(String[] args) {
		String s1="a";
		String s2="a";
		System.out.println(isRotated(s1, s2));
	}

	 public static boolean isRotated(String s1, String s2){
	        int len=s1.length();
	        s1=s1+s1;
	        if(s1.length()==1)
	            return true;
	        if(s2.equals(s1.substring(len-2, len+(len-2))) || s2.equals(s1.substring(len-(len-2), len+2)) ){
	            return true;
	        }
	        return false;
	    }
}

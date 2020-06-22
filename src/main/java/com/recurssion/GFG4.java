package com.recurssion;

import java.util.Scanner;

class GFG4 {
	public static void main (String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int t = scan.nextInt();
	    while(t-- > 0){
	        int n = scan.nextInt();
	        int m = scan.nextInt();
	        int i = 1;
	        while(i <= m){
	            m -= i;
	            i++;
	            if(i == n+1)
	                i=1;
	        }
	        System.out.println(m);
	    }
	}
}
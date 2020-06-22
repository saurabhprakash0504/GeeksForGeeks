package com.sorting;

import java.util.Scanner;

class GFG3 {
	public static void main (String[] args){
		//code
		Scanner in = new Scanner(System.in);
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = in.nextInt();

		while(t-- >0)
		{
		    int n = in.nextInt();
		    int[] temp= new int[n];

		    for(int i=0;i<n;i++)
		        temp[i] = in.nextInt();

		    StringBuffer sb = new StringBuffer();

		    for(int i=0,j=n-1,z=0;i<j;)
		    {
		        sb.append(temp[j--]+" ");
		        sb.append(temp[i++]+" ");
		    }

		    if(n%2!=0)
		        sb.append(temp[temp.length/2]);


		    System.out.println(sb);
		}
	}
}

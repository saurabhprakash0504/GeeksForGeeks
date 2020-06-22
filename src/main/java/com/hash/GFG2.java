package com.hash;
/*package whatever //do not write package name here */

import java.util.HashSet;
import java.util.Scanner;

class GFG2 {
	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int a[] = new int[n];
            int b[]=  new int[m];

            HashSet<Integer> s = new HashSet<>();
            int count = 0;

            // store the elements of first array into set
            for(int i = 0; i < n; i++)
            {
                a[i] = sc.nextInt();
                s.add(a[i]);
            }

            // for each element in the second array
            // check if it is already in set, then
            // remove it from the set
            // and increase the count
            for(int i = 0; i < m; i++)
            {
                b[i] = sc.nextInt();
                if(s.contains(b[i]) == true)
                {
                    s.remove(b[i]);
                    count++;
                }
            }

            System.out.println(count);
        }
    }

}
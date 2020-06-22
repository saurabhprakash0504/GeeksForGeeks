package com.string;

public class MaxCount {
	public static void main(String[] args) {
		System.out.println(getMaxOccuringChar("output"));
		System.out.println(getMaxOccuringChar2("output"));
	}

	public static char getMaxOccuringChar(String line) {
		int[] arr = new int[256];
		for (int i = 0; i < line.length(); i++) {
			arr[line.charAt(i)]++;
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[max] < arr[i]) {
				max = i;
			}
		}

		char ch = (char) max;
		return ch;
	}



	static char getMaxOccuringChar2(String str)
	{
	    int temp[]=new int[256];

	    int max_freq=0;

	    char t=str.charAt(0);

	    for(int i=0;i<str.length();i++)
	    {
	        if(temp[str.charAt(i)]==0)
	            {
	                temp[str.charAt(i)]++;
	            }
	        else
	            {
	                temp[str.charAt(i)]++;

	                if(max_freq==temp[str.charAt(i)])
	                {
	                    if(t>str.charAt(i))
	                        t=str.charAt(i);

	                }

	                if(max_freq<temp[str.charAt(i)])
	                {
	                    max_freq=temp[str.charAt(i)];
	                    t=str.charAt(i);
	                }

	            }
	    }

	    return t;
	}

}

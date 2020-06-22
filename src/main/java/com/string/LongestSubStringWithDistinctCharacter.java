package com.string;

import java.util.Arrays;

public class LongestSubStringWithDistinctCharacter {
	public static void main(String[] args) {
	//	String s = "abkaacdbab";
		//String s = "abaacdb";
		String s = "abcadbd";
		System.out.println(method2(s));
		System.out.println(method3(s));
		System.out.println(longestSubStringEample(s));
	}

	static int method2(String s) {
		int max=0;
		for(int i=0;i<s.length();i++) {
			int curr=0;
			int[] arr = new int[256];
			for(int j=i;j<s.length();j++) {
				if(arr[s.charAt(j)]==0) {
					arr[s.charAt(j)]=1;
					curr+=1;
				}else {
					max = Math.max(curr, max);
					break;
				}
			}
			max = Math.max(curr, max);
		}

		return max;
	}

	static int method3(String str) {
		int n = str.length();
		int res=0;
		int[] arr= new int[256];
		Arrays.fill(arr, -1);
		int i=0;
		for(int j=0;j<n;j++) {
			i =Math.max(i, arr[str.charAt(j)]+1);
			int maxEnd=j-i+1;
			res= Math.max(res, maxEnd);
			arr[str.charAt(j)]=j;
		}
		return res;
	}


	static int longestSubStringEample(String s) {
		int[] arr = new int[256];
		Arrays.fill(arr, -1);
		int j=0;
		int maxLength=0;
		for(int i=0;i<s.length();i++) {
			j=Math.max(j, arr[s.charAt(i)]+1);
			int val=i-j+1;
			maxLength=Math.max(val, maxLength);
			arr[s.charAt(i)]=i;
		}
		return maxLength;
	}
}

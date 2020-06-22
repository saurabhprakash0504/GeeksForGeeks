package com.string;

import java.util.HashSet;

public class PatternSearchingProblem {
	public static void main(String[] args) {
	//	String a = "abcabcbabc";
	//	String b = "abc";
	//	searchRabinKarpAlgo(a, b);
	//	searchRabinKarpAlgoImporvedHash(a, b);

		//lmpAlgo("", "ababab");

		String str="AAABAAAAC";
		int[] arr= new int[str.length()];
		fillLPS(str,arr);
		System.out.println(arr.toString());
	}

	static void searchRabinKarpAlgo(String a, String b) {
		int hashSum = 0;
		int currSum = 0;
		String currString = "";
		for (int i = 0; i < b.length(); i++) {
			hashSum += b.charAt(i);
			currSum += a.charAt(i);

		}
		currString = a.substring(0, b.length());
		if (hashSum == currSum) {
			if (currString.equals(b)) {
				System.out.println("0");
			}
		}

		for (int i = b.length(); i < a.length(); i++) {
			currSum = currSum - a.charAt(i - b.length());
			currSum = currSum + a.charAt(i);

			currString = a.substring(i - b.length() + 1, i + 1);

			if (hashSum == currSum) {
				if (currString.equals(b)) {
					System.out.println(i - b.length() + 1);
				}
			}

		}

	}

	static void searchRabinKarpAlgoImporvedHash(String a, String b) {
		System.out.println("second type");
		int hashSum = 0;
		int currSum = 0;
		int d = 5;
		String currString = "";
		for (int i = 0; i < b.length(); i++) {
			hashSum += (b.charAt(i) * Math.pow(d, b.length() - (i + 1)));
			currSum += (a.charAt(i) * Math.pow(d, b.length() - (i + 1)));

		}
		currString = a.substring(0, b.length());
		if (hashSum == currSum) {
			if (currString.equals(b)) {
				System.out.println("0");
			}
		}

		for (int i = b.length(); i < a.length(); i++) {
			currSum = currSum - (a.charAt(i - b.length()) * (int) Math.pow(d, 2));
			currSum = (d * (currSum) + a.charAt(i)) % 256;

			currString = a.substring(i - b.length() + 1, i + 1);

			if (hashSum == currSum) {
				if (currString.equals(b)) {
					System.out.println(i - b.length() + 1);
				}
			}

		}

	}

	static void lmpAlgo(String text, String pattern) {

		int[] arr = buildLpsArray(pattern);
		System.out.println("arr >> "+arr.toString());
	}

	private static int[] buildLpsArray(String pattern) {
		int[] arr = new int[pattern.length()];
		for (int i = 1; i < arr.length; i++) {
			HashSet<String> prefixSet = prefix(pattern, i);
			HashSet<String> suffixSet = suffix(pattern, i);
			int max = findMax(prefixSet, suffixSet);
			arr[i]= max;
		}

		return arr;
	}

	private static int findMax(HashSet<String> prefixSet, HashSet<String> suffixSet) {
		int max=0;
		for( String s: prefixSet) {
			if(suffixSet.contains(s)) {
				max= Math.max(s.length(), max);
			}
		}
		return max;
	}

	private static HashSet<String> suffix(String pattern, int i) {
		HashSet<String> h = new HashSet<String>();
		String last = "";
		for (int j = i; j >= 0; j--) {
			last =  pattern.charAt(j)+last ;
			h.add(last);
		}
		return h;
	}

	private static HashSet<String> prefix(String pattern, int i) {
		HashSet<String> h = new HashSet<String>();
		String last = "";
		for (int j = 0; j < i; j++) {
			last = last + pattern.charAt(j);
			h.add(last);
		}
		return h;
	}


	static void fillLPS(String str, int[] lps) {
		int n =str.length();
		int len=0;
		lps[0]=0;
		int i=1;
		while(i<n) {
			if(str.charAt(i)== str.charAt(len)) {
				len++;
				lps[i]=len;
				i++;
			}else {
				if(len==0) {
					lps[i]=0;
					i++;
				}else {
					len=lps[len-1];
				}
			}
		}
	}
}

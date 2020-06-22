package com.string;

public class LexographicalRank {
	public static void main(String[] args) {
		String s = "BAC";
		System.out.println(find(s));
	}
	static int find(String s) {
		int[] arr= new int[256];
		int pro=1;
		for(int i=0;i<=s.length()-1;i++) {
			int va=s.charAt(i);
			arr[va]=1;
		}

		for(int i=1;i<256;i++) {
			arr[i]=arr[i]+arr[i-1];
		}

		for(int i=0;i<s.length();i++) {
			System.out.println("val > "+arr[s.charAt(i)]);
			System.out.println("fct ? "+findFact(s.length()-(1+i)));
			pro=pro+(arr[s.charAt(i)]-1)*findFact(s.length()-(1+i));

			for(int j=s.charAt(i);j<=255;j++) {
				arr[j]--;
			}
		}
		return pro;
	}

	static int findFact(int n) {
		int pro=1;
		for(int i=1;i<=n;i++) {
			pro=pro*i;
		}
		return pro;
	}
}

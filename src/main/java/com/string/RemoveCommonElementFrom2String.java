package com.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveCommonElementFrom2String {
	public static void main(String[] args) {
		String s1="rqunudsgdgbcuyqywbvghxsuakuefup";
		String s2="wkjjeocntkowhoofkrbszakvdvrhamyywhidymstwgpdxglhxmcyoourlnz";
		System.out.println(remove(s1, s2));
		System.out.println(remove2(s1, s2));
	}

	static String remove(String s1, String s2) {
		LinkedHashMap<Character, Integer> h = new LinkedHashMap();
		for(char c:s2.toCharArray()) {
			h.put(c, 1);
		}
		StringBuffer sb = new StringBuffer();
		for(char c:s1.toCharArray()) {
			if(h.containsKey(c)) {
				h.put(c, 2);
			}else {
				sb.append(c);
			}
		}

		for(Map.Entry<Character,Integer> m :h.entrySet()) {
			if(m.getValue()==1) {
				sb.append(m.getKey());
			}
		}
		return sb.toString();

	}

	static String remove2(String s1, String s2) {

	       int[] arr = new int[256];

	       for(int i=0;i<s1.length();i++){
	           arr[s1.charAt(i)]=1;
	       }

	       for(int i=0;i<s2.length();i++){
	           arr[s2.charAt(i)]=2;
	       }

	        StringBuffer finalResult= new StringBuffer();

	        for(int i=0;i<s1.length();i++){
	           if(arr[s1.charAt(i)]==1){
	               finalResult=finalResult.append(s1.charAt(i));
	           }
	       }

	       for(int i=0;i<s2.length();i++){
	            if(arr[s2.charAt(i)]==1){
	               finalResult=finalResult.append(s2.charAt(i));
	           }
	       }
	         if(finalResult.toString().length() == 0){
	             return "-1";
	         }else{
	             return finalResult.toString();
	         }
	    }
}

package com.string;

public class ReverseWordInAString {
	public static void main(String[] args) {
		String sd = "i.like.this.program.very.much";
		reverseWords(sd);
	}

	public static void reverseWords(String s) {
	       String[] sd =s.split("\\.");

			for (int i = 0; i < (sd.length / 2); i++) {
				String temp = sd[i];
				sd[i] = sd[sd.length - (1+ i)];
				sd[sd.length -  (1+ i)] = temp;
			}
			//System.out.println(sd.toString());
	       //  System.out.print(".hhehhe");
			StringBuffer sb= new StringBuffer();
	        for(int i=0;i<sd.length;i++){
	            sb.append(sd[i]);
	            sb.append(".");
	        }
	        sb.deleteCharAt(sb.length()-1);
	        System.out.println(sb);
	}
}

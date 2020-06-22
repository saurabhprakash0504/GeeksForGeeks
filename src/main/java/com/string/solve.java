package com.string;

class solve {
	public static String smallestWindow(String s, String t) {

		int len1 = s.length();
		int len2 = t.length();

		if (len1 < len2) {
			return "-1";

		}
		int[] hash_pat = new int[26];
		int[] hash_str = new int[26];

		for (int i = 0; i < len2; i++) {
			hash_pat[t.charAt(i)-97]++;
		}

		int start = 0;
		int start_index = -1;
		int min_len = Integer.MAX_VALUE;
		int count = 0;
		for (int j = 0; j < len1; j++) {
			hash_str[s.charAt(j)-97]++;

			if (hash_pat[s.charAt(j)-97] != 0 && hash_str[s.charAt(j)-97] <= hash_pat[s.charAt(j)-97]) {
				count++;
			}
			if (count == len2) {
				while (hash_str[s.charAt(start)-97] > hash_pat[s.charAt(start)-97] || hash_pat[s.charAt(start)-97] == 0) {
					if (hash_str[s.charAt(start)-97] > hash_pat[s.charAt(start)-97]) {
						hash_str[s.charAt(start)-97]--;
					}
					start++;
				}

				int len_window = j - start + 1;
				if (min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}

		}

		if (start_index == -1) {
			return ("-1");
		} else {
			return (s.substring(start_index, start_index + min_len));
		}
	}

	public static void main(String[] args) {
		String a="aaatatoyyocdt";
		String b="toc";
		System.out.println(smallestWindow(a, b));
	}
}
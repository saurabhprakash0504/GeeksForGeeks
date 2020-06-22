package com.hash;

import java.util.ArrayList;

class GFG4 {

	static int countSubArrayProductLessThanK(ArrayList<Integer> a, long k) {
		int n = a.size();
		long p = 1;
		int res = 0;
		for (int start = 0, end = 0; end < n; end++) {

			// Move right bound by 1 step.
			// Update the product.
			p *= a.get(end);

			// Move left bound so guarantee that
			// p is again less than k.
			while (start < end && p >= k)
				p /= a.get(start++);

			// If p is less than k, update the counter.
			// Note that this is working even for
			// (start == end): it means that the
			// previous window cannot grow anymore
			// and a single array element is the only
			// addendum.
			if (p < k) {
				int len = end - start + 1;
				System.out.println("start >> "+start +" end >> "+end);
				res += len;
			}
		}

		return res;
	}

// Driver Function to count number of
// such arrays
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		System.out.println(countSubArrayProductLessThanK(al, 10));
	}
}

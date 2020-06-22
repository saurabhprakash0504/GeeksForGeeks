package com.linkedlist;

public class CheckForPallindrome {
	static Node head = null;

	public static void main(String[] args) {
		CheckForPallindrome list = new CheckForPallindrome();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = new Node(30);
		list.head.next.next.next.next.next = new Node(20);
		list.head.next.next.next.next.next.next = new Node(10);
		System.out.println("head3 >>> " + isPalindrome(head));
	}

	static boolean isPalindrome(Node head) {
		// Your code here
		Node fast = head;
		Node slow = head;
		int count = 0;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			count++;
		}
		fast = head;
		slow = reverse(slow);
		// return checkit(str);
		while (slow != null) {
			if (fast.data != slow.data) {
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}

	static Node reverse(Node head) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}

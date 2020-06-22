package com.linkedlist;

public class CountNodesInLoop {
	static Node head = null;

	public static void main(String[] args) {
		CountNodesInLoop list = new CountNodesInLoop();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = list.head.next;
		//list.head.next.next = list.head.next;
		System.out.println("head3 >>> " + countNodesinLoop(head));
	}

	static int countNodesinLoop(Node head) {
		// Add your code here.
		Node slow = head;
		Node fast = head.next;
		while (fast == null || fast.next == null || fast != slow) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast == null || fast.next == null) {
			return 0;
		}

		slow=slow.next;
		int count = 1;
		while (slow != fast) {
			slow = slow.next;
			count++;
		}
		return count;
	}
}

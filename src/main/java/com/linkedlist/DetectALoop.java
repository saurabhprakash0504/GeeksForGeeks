package com.linkedlist;

public class DetectALoop {
	static Node head = null;

	public static void main(String[] args) {
		DetectALoop list = new DetectALoop();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = list.head.next;
		// System.out.println("head2 >>>> " + detect2(head));
		 System.out.println("head3 >>> "+detectFloydsAlgo(head));
		// System.out.println("head >>>> " + detect(head));
		System.out.println("head4 >>> " + detectLoop(head));

	}

	static boolean detect(Node head) {
		Node curr = head;
		Node temp = new Node(100);
		while (curr != null) {
			if (curr.next == null) {
				return false;
			} else if (curr.next == temp) {
				return true;
			}
			Node next = curr.next;
			curr.next = temp;
			curr = next;
		}
		return false;
	}

	static boolean detect2(Node head) {
		if (head == null || head.next == null) {
			return false;
		}
		Node fast = head.next;
		Node slow = head;
		while (fast.next != null && fast != null) {
			if (fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}

	static boolean detectFloydsAlgo(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("slowD >> "+slow.data);
				System.out.println("fastD >> "+fast.data);
				return true;
			}
		}

		return false;
	}

	public static int detectLoop(Node head) {
		Node slow = head;
		Node fast = head.next;
		while (fast.next != null && fast != null && slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("slow >> "+slow.data);
		System.out.println("fasr >> "+fast.data);
		if (slow == fast) {
			return 1;
		} else
			return 0;
	}
}

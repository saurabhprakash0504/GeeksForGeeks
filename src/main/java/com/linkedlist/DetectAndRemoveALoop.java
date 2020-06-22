package com.linkedlist;

public class DetectAndRemoveALoop {
	static Node head = null;

	public static void main(String[] args) {
		DetectAndRemoveALoop list = new DetectAndRemoveALoop();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = list.head.next;
		detectLoopAndRemove(head);

	}

	static void detectLoop(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = head;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				while (slow.next != fast) {
					slow = slow.next;
				}
				slow.next = null;
				break;
			}
		}
		printLinkedList(head);
	}

	static void detectFloydsAlgo(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast != slow) {
			return;
		}
		slow = head;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = null;
		printLinkedList(head);
	}

	private static void printLinkedList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println("values >>" + curr.data);
			curr = curr.next;
		}
	}

	public static void detectLoopAndRemove(Node head) {
		Node slow = head;
		Node fast = head.next;
		while (fast.next != null && fast != null && slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		//System.out.println("slow >> " + slow.data);
		//System.out.println("fasr >> " + fast.data);
		if (slow == fast) {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
			printLinkedList(head);
		}
	}
}

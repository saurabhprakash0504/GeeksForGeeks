package com.linkedlist;

public class ReverseLinkedListInGroups {

	static Node head = null;

	public static void main(String[] args) {
		ReverseLinkedListInGroups list = new ReverseLinkedListInGroups();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = new Node(50);
		list.head.next.next.next.next.next = new Node(60);
		// Node rev = reverse(head, 2);
		// Node rev = reversek(head, 2);
		//Node revv = reversek(head, 2);
		Node revv = reversek(head, 4);
		printing(revv);

	}

	static Node reverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list starting
		 * from current. And make rest of the list as next of first node
		 */
		if (next != null)
			head.next = reverse(next, k);

		// prev is now head of input list
		return prev;
	}

	static Node reversek(Node head, int k) {
		Node curr = head, prevfirst = null;
		boolean isFirstPass = true;
		while (curr != null) {
			Node first = curr, prev = null;
			int count = 0;
			while (curr != null && count < k) {
				Node next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}

			if (isFirstPass) {
				head = prev;
				isFirstPass = false;
			} else {
				prevfirst.next = prev;
			}
			prevfirst = first;
		}
		return head;

	}

	static Node reverseOwn2(Node head, int k) {
		Node curr = head;
		Node prev = null;

		boolean isFirstNode = true;
		while (curr != null && curr.next != null) {
			Node next2 = curr.next.next;
			Node second2 = curr.next;
			second2.next = curr;
			curr.next = next2;
			if (isFirstNode) {
				head = second2;
				isFirstNode = false;
			} else {
				prev.next = second2;
			}
			prev = curr;
			curr = curr.next;
		}
		return head;
	}

	static Node reverseOwn3(Node head, int k) {
		Node curr= head;
		int count=0;
		while(curr!=null && count<=k) {
			Node next=curr.next;


		}
		return null;
	}

	static Node reverseOwn(Node head, int k) {
		boolean first = true;
		Node firstNode = null;
		Node lastNode = null;
		Node curr = head;


		while (curr != null) {
			int count = 1;
			lastNode = curr;
			Node currx = curr;
			Node prev = null;
			Node next = null;
			while (currx != null && count <= k) {
				lastNode= currx;
				next = currx.next;
				currx.next = prev;
				prev = currx;
				currx = next;
				count++;
			}
			if (first) {
				firstNode = prev;
			}
			lastNode.next.next=currx;
			curr=currx;



		}
		return firstNode;
	}

	static public void printing(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}

}

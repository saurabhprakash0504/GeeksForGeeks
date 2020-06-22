package com.linkedlist;

public class FindLengthOfLoop {

	static Node head = null;

	public static void main(String[] args) {
		FindLengthOfLoop list = new FindLengthOfLoop();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next= list.head.next.next;
		detectFloydsAlgo(head);

	}

	static void detectFloydsAlgo(Node head) {
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow) {
				break;
			}
		}
		if(fast!=slow) {
			return ;
		}
		int count=1;
		slow=slow.next;
		while(slow!=fast) {
			slow=slow.next;
			count++;
		}
		System.out.println("count >> "+count);
	}
}

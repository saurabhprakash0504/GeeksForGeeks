package com.queue;

import java.util.LinkedList;

import com.linkedlist.Node;

public class ImplementingQueueUsingLinkedList {
	LinkedList<Integer> list = new LinkedList<Integer>();
	Node front = null;
	Node head = null;

	public static void main(String[] args) {
		ImplementingQueueUsingLinkedList i = new ImplementingQueueUsingLinkedList();
		i.enqueue(10);
		i.enqueue(20);
		i.enqueue(30);
		i.enqueue(90);
		i.printingQueue();
		i.deque();
		i.deque();
		i.printingQueue();
		i.enqueue(40);
		i.printingQueue();
		i.deque();
		i.deque();
		i.enqueue(500);
		i.enqueue(600);
		i.enqueue(700);
		i.enqueue(800);

		i.printingQueue();
		i.deque();
		i.deque();
		i.deque();
		i.deque();
		i.printingQueue();

	}

	void enqueue(int data) {
		Node temp = new Node(data);
		if (head == null) {
			head = temp;
			front = temp;
		} else {
			front.next = temp;
			front=front.next;
		}
	}

	int deque() {
		int temp = -1;
		if (head != null) {
			temp = head.data;
			head = head.next;
		}
		return temp;
	}

	void printingQueue() {
		System.out.println(" >>>>>>>> ");
		Node head1=head;
		while(head1!=null) {
			System.out.println(head1.data);
			head1=head1.next;
		}
	}
}

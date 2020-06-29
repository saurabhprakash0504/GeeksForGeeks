package com.queue;

import java.util.LinkedList;

import com.linkedlist.Node;

public class DequeUsingLinkedList {
	LinkedList<Integer> list = new LinkedList<Integer>();
	static Node front = null;
	static Node head = null;
	static Node rear = null;

	public static void main(String[] args) {
		DequeUsingLinkedList d = new DequeUsingLinkedList();
		d.insertFront(10);
		d.insertFront(20);
		d.insertRear(30);
		d.insertRear(40);
		d.insertFront(50);
		d.deleteFront();
		d.deleteRear();
		print();

	}

	private static void print() {
		Node head = front;
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	static void insertFront(int val) {
		Node node = new Node(val);
		if (front == null) {
			front = node;
			rear = node;
		} else {
			node.next = front;
			front = node;
		}
	}

	static void insertRear(int val) {
		Node node = new Node(val);
		if (rear == null) {
			front = node;
			rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
	}

	static int deleteFront() {
		int val = -1;
		if (front != null) {
			val = front.data;
			front = front.next;
		}
		return val;
	}

	static int deleteRear() {
		int val = -1;
		if (rear == null) {
			return -1;
		} else {
			Node temp = front;
			while (temp.next != rear) {
				temp = temp.next;
			}
			val = rear.data;
			temp.next=null;
			rear = temp;
		}
		return val;

	}
}

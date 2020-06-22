package com.linkedlist;

public class AddingANodeInBeginning {
	static Node head;
	public static void main(String[] args) {
		AddingANodeInBeginning.addingNode(30);
		AddingANodeInBeginning.addingNode(70);
		AddingANodeInBeginning.addingNode(10);

		printLinkedList(head);
	}

	private static void printLinkedList(Node head) {
		Node curr=head;
		while(curr!=null) {
			System.out.println(curr.data);
			curr=curr.next;
		}
	}

	static void addingNode(int data) {
		Node newNode = new Node(data);
		newNode.next=head;
		head=newNode;
	}


	static Node addingNodeReturningHead(int data) {
		Node newNode = new Node(data);
		newNode.next=head;
		head=newNode;
		return head;
	}
}

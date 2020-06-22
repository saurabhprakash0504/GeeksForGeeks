package com.linkedlist;

public class NthNodeFromTheEnd {
	public static void main(String[] args) {
		AddingANodeAtEnd addingANodeAtEnd = new AddingANodeAtEnd();
		 Node head = addingANodeAtEnd.insertEndReturnHead(5);
		addingANodeAtEnd.insertEndReturnHead(40);
		addingANodeAtEnd.insertEndReturnHead(130);
		addingANodeAtEnd.insertEndReturnHead(200);
		addingANodeAtEnd.insertEndReturnHead(1000);
		System.out.println(findElement(head, 6));
	}

	static int findElement(Node head, int pos) {
		Node curr=head;
		Node lateCurr=head;
		int i=0;
		while(i<=pos && curr!=null) {
			curr=curr.next;
			i++;
		}
		if(i<pos && curr == null ) {
			return -1;
		}

		while(curr!=null) {
			curr=curr.next;
			lateCurr=lateCurr.next;
		}
		return lateCurr.data;
	}
}

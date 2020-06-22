package com.linkedlist;

public class IntersectionOfTwoList {
	static Node head1 = null;
	static Node head2 = null;

	public static void main(String[] args) {
		IntersectionOfTwoList list = new IntersectionOfTwoList();
		list.head1 = new Node(10);
		list.head1.next = new Node(20);
		list.head1.next.next = new Node(30);
		list.head1.next.next.next = new Node(40);


		IntersectionOfTwoList list2 = new IntersectionOfTwoList();
		list2.head2 = new Node(110);
		list2.head2.next = new Node(120);
		list2.head2.next.next = new Node(130);
		list2.head2.next = list.head1.next.next;
		//list2.head2.next.next.next = new Node(140);

		intersection(head1,head2);
	}

	static void intersection(Node head1, Node head2) {
		Node curr1=head1;
		int length1=0;
		while(curr1!=null) {
			curr1=curr1.next;
			length1++;
		}

		Node curr2=head2;
		int length2=0;
		while(curr2!=null) {
			curr2=curr2.next;
			length2++;
		}

		if(length1>length2) {
			traverse(length1-length2, head1, head2);
		}else {
			traverse(length2-length1, head2, head1);
		}
	}

	private static void traverse(int i, Node head1, Node head2) {
		int j=0;
		Node left=head1;
		while(j<i) {
			left=left.next;
			j++;
		}
		Node right=head2;
		while(left!=null) {
			if(left!= right) {
				left=left.next;
				right=right.next;
			}else {
				System.out.println(left.data);
				return;
			}
		}
		System.out.println("not found");
	}

}

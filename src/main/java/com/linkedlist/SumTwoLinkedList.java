package com.linkedlist;

public class SumTwoLinkedList {
	static Node head1 = null;
	static Node head2 = null;

	public static void main(String[] args) {
		SumTwoLinkedList list = new SumTwoLinkedList();
		//5 5 1 2 6 0 0 9 3 2 8 5 8 9 0 9 6 1 2
		list.head1 = new Node(2);
		list.head1.next = new Node(1);
		list.head1.next.next = new Node(6);
		list.head1.next.next.next = new Node(9);
		list.head1.next.next.next.next = new Node(0);
		list.head1.next.next.next.next.next = new Node(9);
		list.head1.next.next.next.next.next.next = new Node(8);
		list.head1.next.next.next.next.next.next.next = new Node(5);
		list.head1.next.next.next.next.next.next.next.next = new Node(8);
		list.head1.next.next.next.next.next.next.next.next.next = new Node(2);
		list.head1.next.next.next.next.next.next.next.next.next.next = new Node(3);
		list.head1.next.next.next.next.next.next.next.next.next.next.next = new Node(9);
		list.head1.next.next.next.next.next.next.next.next.next.next.next.next = new Node(0);
		list.head1.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(0);
		list.head1.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(6);
		list.head1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next= new Node(2);
		list.head1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(1);
		list.head1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(5);
		list.head1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(5);

		//5 1 3 4 4 3 9 6 2 8 6 8 3 8 2 1 0 2 1
		list.head2 = new Node(1);
		list.head2.next = new Node(2);
		list.head2.next.next = new Node(0);
		list.head2.next.next.next = new Node(1);
		list.head2.next.next.next.next = new Node(2);
		list.head2.next.next.next.next.next = new Node(8);
		list.head2.next.next.next.next.next.next = new Node(3);
		list.head2.next.next.next.next.next.next.next = new Node(8);
		list.head2.next.next.next.next.next.next.next.next = new Node(6);
		list.head2.next.next.next.next.next.next.next.next.next = new Node(8);
		list.head2.next.next.next.next.next.next.next.next.next.next = new Node(2);
		list.head2.next.next.next.next.next.next.next.next.next.next.next = new Node(6);
		list.head2.next.next.next.next.next.next.next.next.next.next.next.next = new Node(9);
		list.head2.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(3);
		list.head2.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(4);
		list.head2.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next= new Node(4);
		list.head2.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(3);
		list.head2.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(1);
		list.head2.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(5);

		Node heads = addTwoLists(head1, head2);
		printing(heads);

	}

	static Node addTwoLists(Node first, Node second) {
		int carry = 0;
		Node tempFirst= first;
		Node tempSecond= second;
		Node end=null;
		while (first != null && second != null) {
			int dataFirst = first.data;
			int dataSecond = second.data;
			int sum = carry + dataFirst + dataSecond;
			first.data = sum % 10;
			second.data = sum % 10;
			carry = sum / 10;
			end=first;
			first = first.next;
			second = second.next;
		}
		if (first == null) {
			while (second != null) {
				int dataSecond = second.data;
				int sum = carry + dataSecond;
				second.data = sum % 10;
				carry = sum / 10;
				end=second;
				second = second.next;

			}
			if(carry!=0) {
				Node temp= new Node (carry);
				end.next=temp;

				Node temps=tempSecond;
				while(tempSecond.next!=null) {
					tempSecond=tempSecond.next;
				}
				tempSecond.next=temp;
				return temps;
			}
			return tempSecond;

		} else {
			while (first != null) {
				int dataSecond = first.data;
				int sum = carry + dataSecond;
				first.data = sum % 10;
				carry = sum / 10;
				first = first.next;
				end=first;
			}
			if(carry!=0) {
				Node temp= new Node (carry);
				end.next=temp;
			}
			return tempFirst;
		}

	}

	private static void printing(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
}

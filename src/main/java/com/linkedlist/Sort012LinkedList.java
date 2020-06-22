package com.linkedlist;

public class Sort012LinkedList {
	static Node head = null;

	public static void main(String[] args) {
		Sort012LinkedList list = new Sort012LinkedList();
		list.head = new Node(2);
		list.head.next = new Node(2);
		list.head.next.next = new Node(2);
		list.head.next.next.next = new Node(1);
//		list.head.next.next.next.next = new Node(2);
//		list.head.next.next.next.next.next = new Node(0);
//		list.head.next.next.next.next.next.next = new Node(2);
//		list.head.next.next.next.next.next.next.next = new Node(2);
		Node head1 = segregate2(head);
		printLinkedList(head1);

	}

	static Node beg0=null;
    static Node beg1=null;
    static Node beg2=null;
     static Node end0=null;
    static Node end1=null;
    static Node end2=null;

    static Node segregate(Node head)
    {

		// add your code here
		while (head != null) {
			int data = head.data;
			Node finalNext = head.next;
			head.next=null;
			if (data == 1 && beg1 == null) {
				beg1 = head;
				end1=head;
			} else if (data == 1) {
				//Node nextBeg1 = beg1.next;
				head.next = beg1;
				beg1 = head;
			}

			if (data == 2 && beg2 == null) {
				beg2 = head;
				end2=head;
			} else if (data == 2) {
				//Node nextBeg2 = beg2.next;
				head.next = beg2;
				beg2 = head;
			}

			if (data == 0 && beg0 == null) {
				beg0 = head;
				end0=head;
			} else if (data == 0) {
				//Node nextBeg0 = beg0.next;
				head.next = beg0;
				beg0 = head;
			}

			head = finalNext;

		}
		end0.next=beg1;
		end1.next=beg2;

		return beg0;

    }

	private static void printLinkedList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}


	 static Node segregate2(Node head)
	    {
	        if(head == null || head.next == null)
	            return head;

	        // Create three dummy nodes to point to
	        // beginning of three linked lists. These
	        // dummy nodes are created to avoid many
	        // null checks.
	        Node zeroD = new Node(0);
	        Node oneD = new Node(0);
	        Node twoD = new Node(0);

	        // Initialize current pointers for three
	        // lists and whole list.
	        Node zero = zeroD, one = oneD, two = twoD;
	        Node curr = head;
	        while(curr != null)
	        {
	            if(curr.data == 0)
	            {
	                zero.next = curr;
	                zero = zero.next;
	                curr = curr.next;
	            }
	            else if(curr.data == 1)
	            {
	                one.next = curr;
	                one = one.next;
	                curr = curr.next;
	            }
	            else
	            {
	                two.next = curr;
	                two = two.next;
	                curr = curr.next;
	            }
	        }
	        // Attach three lists
	        zero.next = (oneD.next  != null) ? (oneD.next) : (twoD.next);
	        one.next = twoD.next;
	        two.next = null;

	        // updated head
	        head = zeroD.next;
	        return head;
	    }

}

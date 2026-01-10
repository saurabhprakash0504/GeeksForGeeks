package com.linkedlist;

public class CheckIfPallindrome {

    public static void main(String[] args) {

        CheckIfPallindrome obj = new CheckIfPallindrome();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        boolean result = obj.isPalindrome(head);
        System.out.println("Is Palindrome: " + result);
    }

    public boolean isPalindrome(Node head) {
        // code here
        if(head == null || head.next == null){
            return true;
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }






        Node secondHalf = reverse(slow);

        Node temp = secondHalf;

        Node first = head;


        while(temp != null){


            if(temp.data != first.data){

                reverse(secondHalf);

              /*  while(head != null){
                    System.out.print(head.data +" ");
                    head = head.next;
                }*/
                return false;
            }

            temp = temp.next;
            first = first.next;

        }


        reverse(secondHalf);

      /*  while(head != null){
            System.out.print(head.data +" ");
            head = head.next;
        }*/
        return true;
    }

    Node reverse(Node curr){

        Node prev = null;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }
}

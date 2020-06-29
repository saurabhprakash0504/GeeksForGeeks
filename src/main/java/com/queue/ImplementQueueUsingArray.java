package com.queue;

public class ImplementQueueUsingArray {
	int[] arr = new int[3];
	int front = 0;
	int rear = -1;
	int currsize = 0;

	public static void main(String[] args) {
		ImplementQueueUsingArray i = new ImplementQueueUsingArray();
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

	private void printingQueue() {
		System.out.println(">>> >> "  );

		if (currsize > 0) {
			int i = front;

			if (i <= rear) {
				while (i <= rear) {
					System.out.println(arr[i]);
					i++;
				}
			} else {
				while (i < arr.length) {
					System.out.println(arr[i]);
					i++;
				}
				i = 0;
				while (i <= rear) {
					System.out.println(arr[i]);
					i++;
				}
			}
		} else {
			System.out.println("not element to display");
		}
	}

	void enqueue(int data) {
		if (currsize < arr.length) {
			rear = (rear + 1) % arr.length;
			arr[rear] = data;
			currsize++;
		}
	}

	int deque() {
		int val = -1;
		if (currsize >= 0) {
			val = arr[front];
			front = (front + 1) % arr.length;
			currsize--;
		}
		return val;
	}

}

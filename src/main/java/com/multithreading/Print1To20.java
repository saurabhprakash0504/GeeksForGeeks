package com.multithreading;

public class Print1To20 {

    public static void main(String[] args) {

        Print1To20 p = new Print1To20();

        Thread t1 = new Thread(() -> p.print(1));
        Thread t2 = new Thread(() -> p.print(2));
        Thread t3 = new Thread(() -> p.print(3));

        t1.start();
        t2.start();
        t3.start();
    }

    int counter = 1;
    int thread = 1;

    synchronized void print(int currThread) {

        while (counter <= 20) {
            while (currThread != thread) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (counter > 20) {
                return;
            }

            System.out.println("counter >> " + counter + " thread >> " + currThread);
            thread = (thread % 3)+1;
            counter++;
            notifyAll();
        }
    }

}


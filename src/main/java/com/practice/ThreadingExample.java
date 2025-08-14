package com.practice;

public class ThreadingExample {

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();

        Integer ind = 1 ;

        t1.start();
        t2.start();
        t3.start();



        synchronized (ind){

            while (ind < 10){
                if(ind%3 ==0){
                    System.out.println("Thread t1+ "+ind);
                }
                else if(ind%3 ==1){
                    System.out.println("Thread t2+ "+ind);
                }
                else if(ind%3 ==2){
                    System.out.println("Thread t3+ "+ind);
                }

                ind++;
            }
        }
    }


}

class T1 extends  Thread{

    public void run(){

    }
}


class T2 extends  Thread{

    public void run(){

    }

}


class T3 extends  Thread{

    public void run(){

    }
}
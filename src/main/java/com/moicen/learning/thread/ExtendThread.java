package com.moicen.learning.thread;


class MyThread_2 extends Thread {
    MyThread_2(String name) {
        super(name);
    }

    public void run() {
        System.out.println(getName() + " starting.");
        try {
            for( int count = 0; count < 10; count++){
                Thread.sleep(400);
                System.out.println("In " + getName() + " , count is " + count);
            }
        } catch (InterruptedException ex){
            System.out.println(getName() + " interrupted.");
        }
        System.out.println(getName() + " terminating.");
    }
}


class ExtendThread {
    public static void main(String args[]){
        System.out.println("Main thread starting.");
        MyThread_2 mt = new MyThread_2("Child 1#");
        mt.start();

        for(int i = 0; i < 50; i++){
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex){
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
    }
}

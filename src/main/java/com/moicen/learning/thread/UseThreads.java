package com.moicen.learning.thread;


class MyThread_1 implements Runnable {
    String thrdName;

    MyThread_1(String name){
        thrdName = name;
    }

    public void run() {
        System.out.println(thrdName + " starting");
        try {
            for(int count = 0; count < 10; count++){
                Thread.sleep(400);
                System.out.println("In " + thrdName + ", count is " + count);
            }
        } catch ( InterruptedException ex){
            System.out.println(thrdName + " interrupted.");
        }
        System.out.println(thrdName + " terminating.");
    }
}


class UseThreads {
    public static void main(String args[]){
        System.out.println("Main thread starting.");

        MyThread_1 mt = new MyThread_1("Child #1");

        Thread newThrd = new Thread(mt);

        newThrd.start();

        for(int i = 0; i < 50; i++){
            System.out.print(".");
            try{
                Thread.sleep(100);
            } catch (InterruptedException ex){
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
    }
}

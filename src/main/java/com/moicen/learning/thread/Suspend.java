package com.moicen.learning.thread;

// Suspending, resuming, and stopping a thread.

class MyThread_5 implements Runnable {
    Thread thread;
    boolean suspended;
    boolean stopped;

    MyThread_5(String name) {
        thread = new Thread(this, name);
        suspended = false;
        stopped = false;
    }

    public static MyThread_5 createAndStart(String name) {
        MyThread_5 myThread5 = new MyThread_5(name);

        myThread5.thread.start();
        return myThread5;
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " starting.");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.print(i + " ");
                if ((i % 10) == 0) {
                    System.out.println();
                    Thread.sleep(250);
                }
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                    if (stopped) break;
                }
            }
        } catch (InterruptedException ex) {
            System.out.println(thread.getName() + " interrupted.");
        }
        System.out.println(thread.getName() + " exiting.");
    }

    synchronized void mystop() {
        stopped = true;
        // ensure a suspended thread can be stopped.
        suspended = false;
        notify();
    }

    synchronized void mysuspend() {
        suspended = true;
    }

    synchronized void myresume() {
        suspended = false;
        notify();
    }
}


class Suspend {
    public static void main(String args[]) {
        MyThread_5 mt1 = MyThread_5.createAndStart("My Thread");

        try {
            Thread.sleep(1000);

            mt1.mysuspend();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            mt1.myresume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);

            mt1.mysuspend();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            mt1.myresume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);

            mt1.mysuspend();
            System.out.println("Stopping thread.");
            mt1.mystop();

        } catch (InterruptedException ex) {
            System.out.println("Main thread interrupted.");
        }

        try {
            mt1.thread.join();
        } catch (InterruptedException ex) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread exiting.");
    }
}

package com.moicen.learning.thread;

class TickTock {
    String state;

    synchronized void tick(boolean running) {
        if (!running) {
            state = "ticked";
            notify(); // notify any waiting threads.
            return;
        }

        System.out.print("Tick ");

        state = "ticked";
        notify();
        try {
            while (!state.equals("tocked"))
                wait(); // wait for tock() to complete
        } catch (InterruptedException ex) {
            System.out.println("Thread interrupted.");
        }
    }

    synchronized void tock(boolean running) {
        if (!running) {
            state = "tocked";
            notify(); // notify any waiting threads.
            return;
        }

        System.out.println("Tock ");

        state = "tocked";
        notify();
        try {
            while (!state.equals("ticked"))
                wait(); // wait for tock() to complete
        } catch (InterruptedException ex) {
            System.out.println("Thread interrupted.");
        }
    }
}

class MyThread_4 implements Runnable {
    Thread thread;
    TickTock tickTock;

    MyThread_4(String name, TickTock tt) {
        thread = new Thread(this, name);
        tickTock = tt;
    }

    public static MyThread_4 createAndStart(String name, TickTock tt) {
        MyThread_4 myThread4 = new MyThread_4(name, tt);
        myThread4.thread.start();
        return myThread4;
    }

    @Override
    public void run() {
        if (thread.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++) tickTock.tick(true);
            tickTock.tick(false);
        } else {
            for (int i = 0; i < 5; i++) tickTock.tock(true);
            tickTock.tock(false);
        }
    }
}


class ThreadCom {

    public static void main(String args[]) {
        TickTock tt = new TickTock();
        MyThread_4 mt1 = MyThread_4.createAndStart("Tick", tt);
        MyThread_4 mt2 = MyThread_4.createAndStart("Tock", tt);

        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException ex) {
            System.out.println("Main thread interrupted.");
        }
    }
}

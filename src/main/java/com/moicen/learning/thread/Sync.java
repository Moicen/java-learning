package com.moicen.learning.thread;


class SumArray {
    private int sum;

    synchronized int sumArray(int nums[]) {
        sum = 0; // reset sum

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            System.out.println("Running total for " + Thread.currentThread().getName() + " is " + sum);

            try{
                Thread.sleep(10); // allow task-switch
            } catch (InterruptedException ex){
                System.out.println("Thread interrupted.");
            }
        }
        return sum;
    }
}

class MyThread_3 implements Runnable {
    Thread thread;
    static SumArray sa = new SumArray();
    int a[];
    int answer;

    MyThread_3(String name, int nums[]){
        thread = new Thread(this, name);
        a = nums;
    }

    public static MyThread_3 createAndStart(String name, int nums[]){
        MyThread_3 myThread3 = new MyThread_3(name, nums);
        myThread3.thread.start();
        return myThread3;
    }

    @Override
    public void run() {
        int sum;
        System.out.println(thread.getName() + " starting");

        answer = sa.sumArray(a);
        System.out.println("Sum for " + thread.getName() + " is " + answer);

        System.out.println(thread.getName() + " terminating.");
    }
}



class Sync {
    public static void main(String args[]){
        int a[] = {1,2,3,4,5};

        MyThread_3 mt1 = MyThread_3.createAndStart("Child #1", a);
        MyThread_3 mt2 = MyThread_3.createAndStart("Child #2", a);

        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException ex){
            System.out.println("Main thread interrupted.");
        }
    }
}

package com.moicen.learning.enumeration;

enum TrafficLightColor {
    RED, GREEN, YELLOW
}


class TrafficLightSimulator implements Runnable {
    private TrafficLightColor tlc;
    private boolean stop = false;
    private  boolean changed = false;

    TrafficLightSimulator(TrafficLightColor init){
        tlc = init;
    }

    TrafficLightSimulator(){
        tlc = TrafficLightColor.RED;
    }

    @Override
    public void run() {
        while (!stop){
            try{
                switch (tlc){
                    case GREEN:
                        Thread.sleep(10000);
                        break;
                    case YELLOW:
                        Thread.sleep(2000);
                        break;
                    case RED:
                        Thread.sleep(12000);
                        break;
                }
            } catch (InterruptedException ex){
                System.out.println(ex);
            }
            changeColor();
        }
    }

    synchronized void changeColor() {
        switch (tlc){
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
                break;
        }
        changed = true;
        notify();
    }

    synchronized void waitForChange() {
        try {
            while (!changed){
                wait();
            }
            changed = false;
        } catch (InterruptedException ex){
            System.out.println(ex);
        }
    }

    synchronized TrafficLightColor getColor() {
        return tlc;
    }

    synchronized void cancel () {
        stop = true;
    }
}


class TrafficLightDemo {
    public static void main(String args[]){
        TrafficLightSimulator tl = new TrafficLightSimulator(TrafficLightColor.GREEN);
        Thread thread = new Thread(tl);
        thread.start();

        for(int i = 0; i < 9; i++){
            System.out.println(tl.getColor());
            tl.waitForChange();
        }

        tl.cancel();
    }
}

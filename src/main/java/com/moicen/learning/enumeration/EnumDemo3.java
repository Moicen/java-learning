package com.moicen.learning.enumeration;

enum Transports {
    CAR(65), TRUCK(55), AIRPLANE(600), TRAIN(70), BOAT(22);

    private int speed;

    Transports(int s) { speed = s; }

    int getSpeed() { return speed; }
}



class EnumDemo3 {
    public static void main(String args[]){
        Transport tp;

        System.out.println("Typical speed for an airplane is " + Transports.AIRPLANE.getSpeed() + " miles per hour. \n");

        System.out.println("All Transport speeds: ");
        for(Transports t : Transports.values())
            System.out.println(t + " typical speed is " + t.getSpeed() + " miles per hour.");
    }
}

package com.moicen.learning.single;
class InchToMeter {
    public static void main(String args[]) {
        double inch = 1, meter;
        int counter;

        for (counter = 0; counter < 12 * 12; counter++) {
            meter = inch * 38.37;
            System.out.println(inch + " inches is " + meter + " meters");

            inch = inch + 1.0;
            if ((counter + 1) % 12 == 0) {
                System.out.println();
            }
        }
    }
}

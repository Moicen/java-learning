package com.moicen.learning.single;
class VarInitDemo {
    public static void main(String argsp[]) {
        int x;
        for (x = 0; x < 3; x++) {
            int y = -1;
            System.out.println("y is: " + y);
            y = 100;
            System.out.println("y is now: " + y);
        }
    }
}

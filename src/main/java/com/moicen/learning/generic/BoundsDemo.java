package com.moicen.learning.generic;

class Numbericfns<T extends Number> {
    T num;

    Numbericfns(T n) {
        num = n;
    }

    double reciprocal() {
        return 1 / num.doubleValue();
    }

    double fraction() {
        return num.doubleValue() - num.intValue();
    }
}

public class BoundsDemo {

    public static void  main(String args[]) {
        Numbericfns<Integer> iOb = new Numbericfns<>(5);

        System.out.println("Reciprocal of iOb is " + iOb.reciprocal());
        System.out.println("Fractional component of iOb is " + iOb.fraction());

        System.out.println();

        Numbericfns<Double> dOb = new Numbericfns<>(5.25);

        System.out.println("Reciprocal of dOb is " + dOb.reciprocal());
        System.out.println("Fractional component of dOb is " + dOb.fraction());

    }
}

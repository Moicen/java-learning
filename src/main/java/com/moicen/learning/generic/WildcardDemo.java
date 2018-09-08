package com.moicen.learning.generic;

class NumbericFns<T extends Number> {
    T num;

    NumbericFns(T n) {
        num = n;
    }

    double reciprocal() {
        return 1 / num.doubleValue();
    }

    double fraction() {
        return num.doubleValue() - num.intValue();
    }

    boolean absEqual(NumbericFns<?> ob) {
        if (Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue()))
            return true;

        return false;
    }
}

public class WildcardDemo {

    public static void main(String args[]) {
        NumbericFns<Integer> iOb = new NumbericFns<>(6);

        NumbericFns<Double> dOb = new NumbericFns<>(-6.0);

        NumbericFns<Long> lOb = new NumbericFns<>(5L);

        System.out.println("Testing iOb and dOb.");

        if (iOb.absEqual(dOb)) {
            System.out.println("Absolute values are equal.");
        } else {
            System.out.println("Absolute values differ.");
        }

        System.out.println();

        System.out.println("Testing iOb and lOb.");

        if (iOb.absEqual(lOb)) {
            System.out.println("Absolute values are equal.");
        } else {
            System.out.println("Absolute values differ.");
        }
    }
}

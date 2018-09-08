package com.moicen.learning.generic;

class TowGen<T, V> {
    T ob1;
    V ob2;

    TowGen(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    void showType() {
        System.out.println("Type of T is " + ob1.getClass().getName());

        System.out.println("Type of V is " + ob2.getClass().getName());
    }

    T getOb1() {
        return ob1;
    }

    V getOb2() {
        return ob2;
    }
}


public class SimpGen {
    public static void main(String args[]){
        TowGen<Integer, String> tgObj = new TowGen<>(88, "Generics");
        tgObj.showType();

        int v = tgObj.getOb1();
        System.out.println("value: " + v);

        String str = tgObj.getOb2();
        System.out.println("value: " + str);
    }
}

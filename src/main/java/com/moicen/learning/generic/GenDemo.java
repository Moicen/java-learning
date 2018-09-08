package com.moicen.learning.generic;


class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType(){
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}

public class GenDemo {

    public static void main(String args[]){
        Gen<Integer> iOb;

        iOb = new Gen<Integer>(88);

        iOb.showType();

        int v = iOb.getOb();
        System.out.println("value: " + v);

        System.out.println();

        Gen<String> strOb = new Gen<String>("Generic Test");

        strOb.showType();

        String str = strOb.getOb();
        System.out.println("value: " + str);
    }
}

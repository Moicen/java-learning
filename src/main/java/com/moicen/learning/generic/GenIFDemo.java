package com.moicen.learning.generic;


interface Containment<T> {
    boolean contains(T o);
}

class MyClass<T> implements Containment<T> {
    T[] arrayRef;

    MyClass(T[] o){
        arrayRef = o;
    }

    public boolean contains(T o){
        for(T x : arrayRef)
            if(x.equals(o)) return true;
        return false;
    }
}



public class GenIFDemo {

    public static void main(String args[]){
        Integer x[] = {1, 2, 3};

        MyClass<Integer> ob = new MyClass<>(x);

        if(ob.contains(2))
            System.out.println("2 is in ob");
        else
            System.out.println("2 is NOT in ob");


        if(ob.contains(5))
            System.out.println("5 is in ob");
        else
            System.out.println("5 is NOT in ob");
    }
}

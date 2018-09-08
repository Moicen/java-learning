package com.moicen.learning.annotation;


@Deprecated
class MyClass {
    private String msg;

    MyClass(String m) {
        msg = m;
    }

    @Deprecated
    String getMsg() {
        return msg;
    }

}

public class AnnoDemo {
    public static void main(String args[]){
        MyClass myClass = new MyClass("test");

        System.out.println(myClass.getMsg());
    }
}

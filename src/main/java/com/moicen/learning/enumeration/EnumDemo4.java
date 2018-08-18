package com.moicen.learning.enumeration;

public class EnumDemo4 {
    public static void main(String args[]){
        Transport tp, tp2, tp3;

        System.out.println("Here are all Transport constants and their ordinal values: ");
        for(Transport t: Transport.values()){
            System.out.println(t + " " + t.ordinal());
        }

        tp = Transport.AIRPLANE;
        tp2 = Transport.TRAIN;
        tp3 = Transport.AIRPLANE;

        System.out.println();

        if(tp.compareTo(tp2) < 0)
            System.out.println(tp + " comes before " + tp2);

        if(tp.compareTo(tp2) > 0)
            System.out.println(tp2 + " comes before " + tp);

        if(tp.compareTo(tp3) == 0)
            System.out.println(tp + " equals " + tp3);
    }
}

package com.moicen.learning.generic;

public class GenQDemo {

    public static void main(String args[]){
        Integer iStore[] = new Integer[10];

        GenQueue<Integer> q = new GenQueue<>(iStore);

        Integer iVal;
        System.out.println("Demonstrate a queue of Integers.");

        try{
            for(int i = 0; i < 5; i++) {
                System.out.println("Adding " + i + " to q.");
                q.put(i);
            }
        } catch (QueueFullException ex){
            System.out.println(ex);
        }
        System.out.println();

        try{
            for(int i = 0; i < 5; i++) {
                System.out.print("Getting next Integer from q: ");
                iVal = q.get();
                System.out.println(iVal);
            }
        } catch (QueueEmptyException ex){
            System.out.println(ex);
        }
        System.out.println();

    }
}

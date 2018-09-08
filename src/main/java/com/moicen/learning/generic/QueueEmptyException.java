package com.moicen.learning.generic;

public class QueueEmptyException extends Exception{
    public String toString(){
        return "\nQueue is empty.";
    }

}

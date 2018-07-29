package com.moicen.learning.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AvgNums {

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        int n;
        double sum = 0.0;
        double avg, t;

        System.out.println("How many numbers will you enter: ");
        str = br.readLine();
        try {
            n = Integer.parseInt(str);
        } catch (NumberFormatException ex){
            System.out.println("Invalid format");
            n = 0;
        }

        System.out.println("Enter " + n + " values.");
        for(int i = 0; i < n; i++){
            System.out.println(": ");
            str = br.readLine();
            try {
                t = Double.parseDouble(str);
            } catch (NumberFormatException ex){
                System.out.println("Invalid format");
                t = 0.0;
            }
            sum += t;
        }
        avg = sum / n;
        System.out.println("Average is " + avg);
    }
}

package com.moicen.learning.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DtoS {
    public static void main(String args[]) {
        String s;

        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex);
        }
    }
}

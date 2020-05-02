package com.problems.Flippingbits;

import java.nio.ByteBuffer;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = in.nextInt();

        int flippedNumber = filp(num);
        System.out.println(flippedNumber);
    }

    static int filp(int num) {

        byte[] binary = new byte[32];
        int index = 0;
        int copyOfInput = num;
        while (copyOfInput > 0) {
            binary[index++] = (byte) (copyOfInput % 2);
            copyOfInput = copyOfInput / 2;
        }

        byte[] fillbinary = new byte[32];

        for (int i = 0; i < fillbinary.length; i++) {
            byte b = fillbinary[i];
            if (b == 1) {
                binary[i] = 0;
            }
            if (b == 0) {
                binary[i] = 1;
            }
        }

        return ByteBuffer.wrap(binary).getInt();

    }
}

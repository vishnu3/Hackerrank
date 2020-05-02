package com.problems.Flippingbits;

import java.nio.ByteBuffer;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = in.nextInt();

        int flippedNumber = filp(num);
    }

    static int filp(int num) {

        byte[] binNum = toBinary(num);


        System.out.println("binNum length "+binNum.length);

        int fillpedNumber  =  binToInt(binNum);
        System.out.println(" fillpedNumber " +fillpedNumber);

        return fillpedNumber;
    }

    public static byte[] toBinary(int number) {
        byte[] binary = new byte[32];
        int index = 0;
        int copyOfInput = number;
        while (copyOfInput > 0) {
            binary[index++] = (byte) (copyOfInput % 2);
            copyOfInput = copyOfInput / 2;
        }
        return binary;
    }

    public static int binToInt(byte[] bin){
        byte[] binary = new byte[32];

        for (int i = 0 ; i<bin.length; i++){
            byte b = bin[i];
            if(b==1){
              binary[i] = 0;
            } if (b==0) {
                binary[i] = 1;
            }
        }

        return ByteBuffer.wrap(binary).getInt();

    }


}

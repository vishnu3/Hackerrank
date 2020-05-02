package com.problems.test2.Day4;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

public class Solution {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] dummy = new int[a.length];
        int[] partOne = new int[d];
        int[] partTwo = new int[a.length-d];

        for (int i = 0; i <d ; i++) {
            partOne[i] = a[i];
        }

        for (int i = d,j=0; i <a.length; i++,j++) {
            partTwo[j] = a[i];
        }

        for (int i = 0; i <partTwo.length ; i++) {
            dummy[i] = partTwo[i];
        }

        for (int i = 0; i <partOne.length ; i++) {
            dummy[partTwo.length+i] = partOne[i];
        }

        return dummy;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("C:/VishnuJ/test-projects/test-delete/testout.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        System.out.println("result "+result);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


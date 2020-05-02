package com.problems.test2.Day3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {


        ArrayList<Integer> list = new ArrayList<>();

        for (int m = 0; m < 4; m++) {
            for (int i = 0; i < 4; i++) {

                int sum = 0;

                for (int j = i; j < 3 + i; j++) {
                    for (int k = m; k < 3 + m; k++) {
                        if(( k==m && j==1+i ) || ( j==1+i  && k==2+m )){

                        }else{
                            sum = sum + arr[j][k];
                        }

                    }
                }
                list.add(sum);
            }
        }

        return list.stream().mapToInt(i -> i).max().orElse(0);



    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("C:/VishnuJ/test-projects/test-delete/testout.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println("result " + result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();


    }
}

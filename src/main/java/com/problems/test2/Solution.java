package com.problems.test2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the sockMerchant function below.
    static long repeatedString(String s, long n) {
        if(!s.contains("a")) return 0;

        StringBuilder dummy = new StringBuilder((int)n);
        System.out.println("dummy lenght "+dummy.length());
        while(dummy.length()<=n){
            dummy.append(s);
        }

        dummy.trimToSize();

        if(dummy.length()>n){
           dummy.delete((int)n-1,dummy.length()-1);
        }

        List<Character> list = dummy.chars().mapToObj(e ->(char)e).collect(Collectors.toList());

        int count = Collections.frequency(list,'a');

     return count;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        File file = new File("C:/VishnuJ/test-projects/test-delete/testout.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println("result "+result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


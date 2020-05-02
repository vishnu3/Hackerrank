package com.problems.ps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getMinCost' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY employee_id
     *  2. INTEGER_ARRAY job_id
     */

    public static long getMinCost(List<Integer> employee_id, List<Integer> job_id) {
        int length = employee_id.size();
        int cost = 0;

        for(int i =0; i<length;i++){

            Integer minEmp = findMin(employee_id);
            employee_id.remove(minEmp);

            Integer minJob = findMin(job_id);
            job_id.remove(minJob);

            Integer minCost = minEmp - minJob;
            if(minCost<0){
              minCost = minCost*-1;
            }
            cost += minCost;
        }
      return cost;
    }

    public static Integer findMin(List<Integer> list){
        return list.stream().min(Integer::compareTo).get();

    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("C:/VishnuJ/test-projects/test-delete/testout.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        int employee_idCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> employee_id = IntStream.range(0, employee_idCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int job_idCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> job_id = IntStream.range(0, job_idCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.getMinCost(employee_id, job_id);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


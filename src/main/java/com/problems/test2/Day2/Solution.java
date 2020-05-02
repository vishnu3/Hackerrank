package com.problems.test2.Day2;

import org.omg.CORBA.INTERNAL;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    public static int maxScore(List<Integer> a, int m) {

        List<Integer> sortedList = a.stream().sorted().collect(Collectors.toList());
        int listSize = sortedList.size();
        int qnt = listSize / m;
        HashMap<Integer, List<Integer>> listLinkedHashMap = new HashMap<>();
        int startIndex = 0;
        int lastIndex = m;
        int addPos = m;
        int sum = 0;
        for (int i = 0; i < qnt; i++) {
            List<Integer> list = new ArrayList<>(sortedList.subList(startIndex, lastIndex));
            startIndex = lastIndex;
            lastIndex = lastIndex + addPos;
            listLinkedHashMap.put(i, list);

            if(!(i==(qnt-1))){
                sum = sum + (i+1) * (list.stream().mapToInt(j -> j).sum());
            }
        }
        int mapSize = listLinkedHashMap.size();
        if (listSize > (qnt * m)) {
            List<Integer> remainingItm = new ArrayList<>(sortedList.subList(qnt * (m), listSize));

            List<Integer> lastList = listLinkedHashMap.get(mapSize - 1);
            lastList.addAll(remainingItm);

           // listLinkedHashMap.put(mapSize - 1, lastList);
            sum = sum + (qnt) * (lastList.stream().mapToInt(j -> j).sum());

        }else {
            List<Integer> lastList = listLinkedHashMap.get(mapSize - 1);
            //listLinkedHashMap.put(mapSize - 1, lastList);
            sum = sum + (qnt) * (lastList.stream().mapToInt(j -> j).sum());

        }

       /* int sum = 0;

        for (Map.Entry<Integer, List<Integer>> entry : listLinkedHashMap.entrySet()) {
            int index = entry.getKey() + 1;
            List<Integer> list = new ArrayList<>(entry.getValue());
            sum = sum + index * (list.stream().mapToInt(i -> i).sum());
        }
*/

        int MOD = 1000000007;
        return sum % (MOD);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("C:/VishnuJ/test-projects/test-delete/testout.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int ans = Result.maxScore(a, m);
        System.out.println("ans " + ans);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

    }
}


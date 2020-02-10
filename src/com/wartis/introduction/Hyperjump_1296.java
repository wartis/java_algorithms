package com.wartis.introduction;

import java.util.Scanner;

public class Hyperjump_1296 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in, "ISO-8859-1");
        int n = scanner.nextInt();
        int maxSum = 0;
        int curSum = 0;
        for (int i=0; i<n; i++){
            int curNum = scanner.nextInt();
            curSum = Math.max((curSum + curNum), 0);
            if (curSum > maxSum) maxSum = curSum;
        }
        System.out.println(maxSum);
    }
}

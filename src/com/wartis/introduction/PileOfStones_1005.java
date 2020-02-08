package com.wartis.introduction;

import java.util.ArrayList;
import java.util.Scanner;

public class PileOfStones_1005 {

    public static ArrayList<Integer> numbers = new ArrayList<>(); // лучше массив, но мне лень
    public static int minValue = Integer.MAX_VALUE;

    public static void f(int i, int pile1, int pile2) {
        if (i == numbers.size()) {
            int localMin = Math.abs(pile1-pile2);
            if (localMin < minValue) minValue = localMin;
            return;
        }
        i += 1;
        f(i, pile1 + numbers.get(i-1), pile2);
        f(i, pile1, pile2  + numbers.get(i-1));
    }


    public static void main (String ... args) {
        Scanner scanner = new Scanner(System.in, "ISO-8859-1");
        int n = scanner.nextInt();
        for (int i = n; i>=1; i--) {
            int curNum = scanner.nextInt();
            numbers.add(curNum);
        }
        f(0,0,0);
        System.out.println(minValue);
    }
}

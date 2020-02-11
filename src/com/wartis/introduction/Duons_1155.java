package com.wartis.introduction;

import java.util.Scanner;

public class Duons_1155 {
    public static void main(String ... args) {
        Scanner scanner = new Scanner(System.in, "ISO-8859-1");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        int g = scanner.nextInt();
        int h = scanner.nextInt();

        new DuonsSolver(a, b, c, d, e, f, g, h).solve();
    }
}

class DuonsSolver {

    private int A, B, C, D, E, F, G, H;

    public DuonsSolver(int a, int b, int c, int d, int e, int f, int g, int h) {
        A = a;
        B = b;
        C = c;
        D = d;
        E = e;
        F = f;
        G = g;
        H = h;
    }

    void solve() {
        if (A+C+H+F != G+E+B+D) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        while (A+C+H+F != 0) {
            if (A>0 && G>0) {
                A--;
                G--;
                System.out.println("EH+");
                System.out.println("AE-");
                System.out.println("GH-");
            }
            if (A>0 && E>0){
                A--;
                E--;
                System.out.println("AE-");
            }
            if (A>0 && B>0){
                A--;
                B--;
                System.out.println("AB-");
            }
            if (A>0 && D>0){
                A--;
                D--;
                System.out.println("AD-");
            }

            if (C>0 && E>0) {
                C--;
                E--;
                System.out.println("AB+");
                System.out.println("AE-");
                System.out.println("BC-");
            }
            if (C>0 && B>0){
                C--;
                B--;
                System.out.println("CB-");
            }
            if (C>0 && D>0) {
                C--;
                D--;
                System.out.println("CD-");
            }
            if (C>0 && G>0){
                C--;
                G--;
                System.out.println("CG-");
            }

            if (H>0 && B>0) {
                H--;
                B--;
                System.out.println("EA+");
                System.out.println("AB-");
                System.out.println("EH-");
            }
            if (H>0 && G>0){
                H--;
                G--;
                System.out.println("HG-");
            }
            if (H>0 && E>0) {
                H--;
                E--;
                System.out.println("HE-");
            }
            if (H>0 && D>0){
                H--;
                D--;
                System.out.println("HD-");
            }

            if (F>0 && D>0) {
                F--;
                D--;
                System.out.println("EH+");
                System.out.println("FE-");
                System.out.println("DH-");
            }
            if (F>0 && B>0) {
                F--;
                B--;
                System.out.println("FB-");
            }
            if (F>0 && E>0) {
                F--;
                E--;
                System.out.println("FE-");
            }
            if (F>0 && G>0) {
                F--;
                G--;
                System.out.println("FG-");
            }
        }
    }
}
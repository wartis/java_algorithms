package com.wartis.introduction;

import java.util.Scanner;

public class Players_1401 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in,"ISO-8859-1");
        int power = scanner.nextInt();
        int x_pinked = scanner.nextInt();
        int y_pinked = scanner.nextInt();

        int size = 1;
        for (int k=0; k<power; k++) size *= 2;

        int arr [] [] = new int[size] [size];

        PlayersSolver solver = new PlayersSolver(arr, size);
        solver.solve(0, 0, x_pinked-1, y_pinked-1, size);

        for (int i=0; i<solver.matrix.length; i++) {
            for (int j=0; j<solver.matrix.length; j++) System.out.print(solver.matrix[i][j] + " ");
            System.out.println();
        }
    }
}

//нагло своровано
class PlayersSolver {
    int matrix [][];
    int size;
    int COUNTER;


    PlayersSolver(int arr[][], int size) {
        this.matrix  = arr;
        this.size    = size;
        this.COUNTER = 1;
    }

    void add_figure(int i, int j) {
        int tmp_i = i % 2;
        int tmp_j = j % 2;

        if (tmp_i == 1 && tmp_j == 1) {
            matrix[i - 1][j - 1] = matrix[i - 1][j] = matrix[i][j - 1] = COUNTER++;

        }
        else if (tmp_i == 0 && tmp_j == 0) {
            matrix[i + 1][j + 1] = matrix[i + 1][j] = matrix[i][j + 1] = COUNTER++;

        }
        else if (tmp_i == 0 && tmp_j == 1) {
            matrix[i + 1][j] = matrix[i][j - 1] = matrix[i + 1][j - 1] = COUNTER++;

        }
        else if (tmp_i == 1 && tmp_j == 0) {
            matrix[i - 1][j] = matrix[i][j + 1] = matrix[i - 1][j + 1] = COUNTER++;

        }
    }

    void solve(int rows_start, int cols_start, int i, int j, int size) {
        if (size == 2) {
            add_figure(rows_start + i % 2, cols_start + j % 2);
            return;
        }

        int new_size = size / 2;

        if (i >= new_size && j >= new_size) {
            solve(rows_start + new_size, cols_start + new_size, i - new_size, j - new_size, new_size);

            matrix[rows_start + new_size - 1][cols_start + new_size - 1] =
                    matrix[rows_start + new_size][cols_start + new_size - 1] =
                            matrix[rows_start + new_size - 1][cols_start + new_size] = COUNTER++;

            solve(rows_start, cols_start + new_size, new_size - 1, 0, new_size);
            solve(rows_start, cols_start, new_size - 1, new_size - 1, new_size);
            solve(rows_start + new_size, cols_start, 0, new_size - 1, new_size);

        }
        else if (i < new_size && j < new_size) {
            solve(rows_start, cols_start, i, j, new_size);

            matrix[rows_start + new_size][cols_start + new_size] =
                    matrix[rows_start + new_size][cols_start + new_size - 1] =
                            matrix[rows_start + new_size - 1][cols_start + new_size] = COUNTER++;

            solve(rows_start + new_size, cols_start + new_size, 0, 0, new_size);
            solve(rows_start, cols_start + new_size, new_size - 1, 0, new_size);
            solve(rows_start + new_size, cols_start, 0, new_size - 1, new_size);

        }
        else if (i < new_size && j >= new_size) {
            solve(rows_start, cols_start + new_size, i, j - new_size, new_size);

            matrix[rows_start + new_size][cols_start + new_size] =
                    matrix[rows_start + new_size][cols_start + new_size - 1] =
                            matrix[rows_start + new_size - 1][cols_start + new_size - 1] = COUNTER++;

            solve(rows_start, cols_start, new_size - 1, new_size - 1, new_size);
            solve(rows_start + new_size, cols_start + new_size, 0, 0, new_size);
            solve(rows_start + new_size, cols_start, 0, new_size - 1, new_size);

        }
        else {
            solve(rows_start + new_size, cols_start, i - new_size, j, new_size);

            matrix[rows_start + new_size][cols_start + new_size] =
                    matrix[rows_start + new_size - 1][cols_start + new_size] =
                            matrix[rows_start + new_size - 1][cols_start + new_size - 1] = COUNTER++;

            solve(rows_start, cols_start, new_size - 1, new_size - 1, new_size);
            solve(rows_start + new_size, cols_start + new_size, 0, 0, new_size);
            solve(rows_start, cols_start + new_size, new_size - 1, 0, new_size);
        }
    }
}

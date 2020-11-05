package com.bsu.by;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter size of row: ");
            int row = sc.nextInt();
            System.out.println("Enter size of col: ");
            int col = sc.nextInt();
            if (row <= 0 || col <= 0) {
                throw new Exception("Error! Row and col should be natural numbers.");
            }

            int[][] matrix = new int[row][col];
            createMatrix(matrix);
            printMatrix(matrix);
            System.out.println();
            findDoublMax(matrix);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    static void createMatrix(int[][] matrix) {
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(10);
                //System.out.println("matrix[" + i + "][" + j + "]= " + matrix[i][j]);
            }
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    static int[] sortMatrix(int[][] matrix) {
        int[] flat = new int[matrix.length * matrix[0].length];
        int ctr = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                flat[ctr++] = matrix[i][j];
            }
        }

        Arrays.sort(flat);

        return flat;
    }

    static void findDoublMax(int[][] matrix) {
        int[] arr = sortMatrix(matrix);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        int max = -1;
        if (arr[0] == arr[1] && arr[1] != arr[2]) {
            max = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i + 1]) {
                if(arr[i] != arr[i + 2] && arr[i] != arr[i - 1])
                max = i + 1;
            }
        }
        System.out.println("after for");

        if (max != -1) {
            System.out.println("Max element repeated twice: " + max);
        } else {
            System.out.println("No elements repeated twice");
        }

    }
}

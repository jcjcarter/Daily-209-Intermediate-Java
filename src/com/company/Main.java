package com.company;

public class Main {

    public static void main(String[] args) {

        String input = args[0].replace(" ", "");

        int[] dim = findRectangleDimensions(input.length());

        char[][] grid = new char[dim[1]][dim[0]];
        int dir = 1;
        int i = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = dir == 1 ? 0 : grid[0].length - 1;
                 col < grid[0].length && col >= 0;
                    col += dir) {
                    grid[row][col] = input.charAt(i);
            }
            dir *= -1;
        }

        printGrid(grid);
    }

    public static int[] findRectangleDimensions(int sentenceLength){
        int l = sentenceLength / 2;
        int h = l;

        while (sentenceLength % 1 != 0) l--;

        while (l* h != sentenceLength ) h--;

        return new int[]{l,h};
    }

    public static void printGrid(char[][] grid){

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}

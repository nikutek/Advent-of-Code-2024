package day4.part2;

import java.util.ArrayList;
import java.util.List;

import InputReader.InputReader;

public class CeresSearch2 {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        ArrayList<String> input = inputReader.getInput("./day4/input.txt");
        ArrayList<ArrayList<String>> rows = transformInput(input);
        int answer = 0;

        for (int row = 0; row < rows.size() - 2; row++) {
            for (int col = 0; col <= rows.get(row).size() - 3; col++) {
                List<String> firstRow = rows.get(row).subList(col, col + 3);
                List<String> secondRow = rows.get(row + 1).subList(col, col + 3);
                List<String> thirdRow = rows.get(row + 2).subList(col, col + 3);

                System.out.println("Checking at row: " + row + ", col: " + col);
                System.out.println(firstRow);
                System.out.println(secondRow);
                System.out.println(thirdRow);

                if (isXmas(firstRow, secondRow, thirdRow)) {
                    System.out.println("true");
                    answer++;
                }
                System.out.println("---------------");
            }
        }

        System.out.println(answer);
    }

    public static ArrayList<ArrayList<String>> transformInput(ArrayList<String> input) {
        ArrayList<ArrayList<String>> rows = new ArrayList<>();
        for (String line : input) {
            ArrayList<String> letters = new ArrayList<>();
            for (String letter : line.split("")) {
                letters.add(letter);
            }
            rows.add(letters);
        }
        return rows;
    }

    public static boolean isXmas(List<String> firstRow, List<String> secondRow, List<String> thirdRow) {
        if (firstRow.get(0).equals("M") &&
                firstRow.get(2).equals("S") &&
                secondRow.get(1).equals("A") &&
                thirdRow.get(0).equals("M") &&
                thirdRow.get(2).equals("S")) {
            return true;
        }

        if (firstRow.get(0).equals("S") &&
                firstRow.get(2).equals("S") &&
                secondRow.get(1).equals("A") &&
                thirdRow.get(0).equals("M") &&
                thirdRow.get(2).equals("M")) {
            return true;
        }

        if (firstRow.get(0).equals("S") &&
                firstRow.get(2).equals("M") &&
                secondRow.get(1).equals("A") &&
                thirdRow.get(0).equals("S") &&
                thirdRow.get(2).equals("M")) {
            return true;
        }

        if (firstRow.get(0).equals("M") &&
                firstRow.get(2).equals("M") &&
                secondRow.get(1).equals("A") &&
                thirdRow.get(0).equals("S") &&
                thirdRow.get(2).equals("S")) {
            return true;
        }

        return false;
    }
}

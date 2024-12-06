package day4.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import InputReader.InputReader;

public class CeresSearch {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        ArrayList<String> input = inputReader.getInput("./day4/input.txt");
        ArrayList<ArrayList<String>> rows = transformInput(input);
        int answer = 0;
        System.out.println(rows);

        // Przeszukiwanie poziomo
        for (int row = 0; row < rows.size(); row++) {
            System.out.println(rows.get(row));
            for (int col = 0; col <= rows.get(row).size() - 4; col++) {
                List<String> letters = rows.get(row).subList(col, col + 4);
                if (isXmas(rows.get(row).subList(col, col + 4))) {
                    System.out.println("true " + letters);
                    answer++;
                }
            }
        }

        // Przeszukiwanie pionowo
        for (int col = 0; col < rows.get(0).size(); col++) {
            for (int row = 0; row <= rows.size() - 4; row++) {
                List<String> letters = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    letters.add(rows.get(row + i).get(col));
                }
                if (isXmas(letters)) {
                    System.out.println("true " + letters);
                    answer++;
                }
            }
        }

        // Przeszukiwanie poprzecznie w prawo
        for (int row = 0; row <= rows.size() - 4; row++) {
            for (int col = 0; col <= rows.get(0).size() - 4; col++) {
                List<String> letters = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    letters.add(rows.get(row + i).get(col + i));
                }
                if (isXmas(letters)) {
                    System.out.println("true " + letters);
                    answer++;
                }
            }
        }
        // Przeszukiwanie poprzecznie w lewo
        for (int row = 0; row <= rows.size() - 4; row++) {
            for (int col = 3; col < rows.get(0).size(); col++) {
                List<String> letters = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    letters.add(rows.get(row + i).get(col - i));
                }
                if (isXmas(letters)) {
                    System.out.println("true " + letters);
                    answer++;
                }
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

    public static boolean isXmas(List<String> letters) {
        return letters.equals(Arrays.asList("X", "M", "A", "S")) || letters.equals(Arrays.asList("S", "A", "M", "X"));
    }
}

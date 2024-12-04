package day2.part1;

import java.util.ArrayList;

import InputReader.InputReader;

public class RedNosedReports {
    public static void main(String[] args) {
        InputReader ipr = new InputReader();
        ArrayList<String> input = ipr.getInput("./day2/input.txt");
        int answer = 0;

        for (String row : input) {
            ArrayList<Integer> levels = new ArrayList<>();

            for (String num : row.split(" ")) {
                levels.add(Integer.valueOf(num));
            }

            if (checkIfSafe(levels)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean checkIfSafe(ArrayList<Integer> levels) {

        Integer first = levels.get(0);
        Integer second = levels.get(1);
        String mode = first < second ? "increasing" : "decreasing";
        System.out.println(levels + " " + mode);

        for (int i = 1; i < levels.size(); i++) {
            if (mode.equals("increasing")) {
                int difference = levels.get(i) - levels.get(i - 1);
                if (levels.get(i) <= levels.get(i - 1)) {
                    System.out.println("incorectly decreasing");
                    return false;
                } else if (difference > 3) {
                    System.out.println("too much difference");
                    return false;
                }

            } else if (mode.equals("decreasing")) {
                int difference = Math.abs(levels.get(i) - levels.get(i - 1));
                if (levels.get(i) >= levels.get(i - 1)) {
                    System.out.println("incorectly increasing");
                    return false;
                } else if (difference > 3) {
                    System.out.println("too much difference");
                    return false;
                }
            }
        }
        return true;
    }
}

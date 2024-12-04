package day2.part2;

import java.util.ArrayList;

import InputReader.InputReader;

public class RedNosedReports2 {
    public static void main(String[] args) {
        System.out.println();
        InputReader ipr = new InputReader();
        ArrayList<String> input = ipr.getInput("./day2/input.txt");
        int answer = 0;

        for (String row : input) {
            ArrayList<Integer> levels = new ArrayList<>();
            for (String level : row.split(" ")) {
                levels.add(Integer.valueOf(level));
            }

            boolean isSafe = checkIfSafe(levels);

            if (isSafe) {
                System.out.println(levels + " safe");
                answer++;
            } else {

                ArrayList<ArrayList<Integer>> modifiedLevels = new ArrayList<>();
                for (int i = 0; i < levels.size(); i++) {
                    ArrayList<Integer> modified = new ArrayList<>();
                    modified.addAll(levels);
                    modified.remove(i);
                    modifiedLevels.add(modified);
                }

                boolean isSafeWhenModified = false;
                for (ArrayList<Integer> modified : modifiedLevels) {
                    if (checkIfSafe(modified)) {
                        isSafeWhenModified = true;
                        System.out.println(levels + "safe by modifying to " + modified);
                        answer++;
                        break;
                    }
                }
                if (!isSafeWhenModified) {
                    System.out.println(levels + " unsafe regardless");
                }
            }

        }

        System.out.println(answer);
    }

    public static boolean checkIfSafe(ArrayList<Integer> levels) {

        Integer first = levels.get(0);
        Integer second = levels.get(1);
        String mode = first < second ? "increasing" : "decreasing";

        for (int i = 1; i < levels.size(); i++) {
            if (mode.equals("increasing")) {
                int difference = levels.get(i) - levels.get(i - 1);
                if (levels.get(i) <= levels.get(i - 1)) {
                    return false;
                } else if (difference > 3) {
                    return false;
                }

            } else if (mode.equals("decreasing")) {
                int difference = Math.abs(levels.get(i) - levels.get(i - 1));
                if (levels.get(i) >= levels.get(i - 1)) {
                    return false;
                } else if (difference > 3) {
                    return false;
                }
            }
        }
        return true;
    }
}

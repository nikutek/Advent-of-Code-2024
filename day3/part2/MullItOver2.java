package day3.part2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import InputReader.InputReader;

public class MullItOver2 {
    public static void main(String[] args) {
        System.out.println();
        InputReader ipr = new InputReader();
        // ArrayList<String> input = ipr.getInput("./day3/testInput.txt");
        ArrayList<String> input = ipr.getInput("./day3/input.txt");
        int answer = 0;
        Boolean enabled = true;

        for (String line : input) {
            ArrayList<String> matches = new ArrayList<>();

            Pattern combinedRegex = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\)");
            Matcher matcher = combinedRegex.matcher(line);

            while (matcher.find()) {
                matches.add(matcher.group());
            }

            for (String match : matches) {
                System.out.println(match);

                if (match.equals("don't()")) {
                    enabled = false;
                } else if (match.equals("do()")) {
                    enabled = true;
                } else {
                    if (enabled) {
                        match = match.substring(4, match.length() - 1);
                        String parts[] = match.split(",");

                        int multiplied = Integer.valueOf(parts[0]) * Integer.valueOf(parts[1]);
                        System.out.println(parts[0] + " * " + parts[1] + " = " + multiplied);
                        answer += multiplied;
                    }
                }

            }
        }

        System.out.println(answer);
    }

}

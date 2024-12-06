package day3.part1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import InputReader.InputReader;

public class MullItOver {
    public static void main(String[] args) {
        System.out.println();
        InputReader ipr = new InputReader();
        ArrayList<String> input = ipr.getInput("./day3/input.txt");
        int answer = 0;

        for (String line : input) {
            ArrayList<String> matches = new ArrayList<>();

            Pattern regex = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
            Matcher matcher = regex.matcher(line);

            while (matcher.find()) {
                matches.add(matcher.group());
            }

            for (String match : matches) {
                match = match.substring(4, match.length() - 1);
                String parts[] = match.split(",");

                int multiplied = Integer.valueOf(parts[0]) * Integer.valueOf(parts[1]);
                answer += multiplied;
            }
        }

        System.out.println(answer);
    }

}

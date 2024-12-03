import java.util.ArrayList;
import java.util.Collections;
import InputReader.*;

public class HistorianHysteria {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        ArrayList<String> input = inputReader.getInput("./day1/input.txt");

        ArrayList<Integer> leftColumn = new ArrayList<>();
        ArrayList<Integer> rightColumn = new ArrayList<>();

        input.stream().forEach((String row) -> {
            String[] rows = row.split("   ");
            leftColumn.add(Integer.valueOf(rows[0]));
            rightColumn.add(Integer.valueOf(rows[1]));
        });

        Collections.sort(leftColumn);
        Collections.sort(rightColumn);

        int totalDistance = 0;

        for (int i = 0; i < leftColumn.size(); i++) {
            int distance = Math.abs(leftColumn.get(i) - rightColumn.get(i));
            System.out.println(leftColumn.get(i) + ", " + rightColumn.get(i) + " distance: " + distance);
            totalDistance += distance;
        }

        System.out.println(totalDistance);

    }
}

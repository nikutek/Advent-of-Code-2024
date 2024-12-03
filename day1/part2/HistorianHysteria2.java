import java.util.ArrayList;
import InputReader.*;

public class HistorianHysteria2 {

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

        int totalSimilarityScore = 0;
        for (int numLeft : leftColumn) {
            int accurance = 0;
            for (int numRight : rightColumn) {
                if (numRight == numLeft) {
                    accurance++;
                }
            }
            int similarity = numLeft * accurance;
            System.out.println(numLeft + " " + similarity);
            totalSimilarityScore += similarity;
        }
        System.out.println(totalSimilarityScore);
    }
}

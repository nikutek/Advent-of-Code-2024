package InputReader;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    private ArrayList<String> input = new ArrayList<>();

    public ArrayList<String> getInput(String file) {
        try (Scanner fileScanner = new Scanner(Paths.get(file))) {
            while (fileScanner.hasNextLine()) {
                String row = fileScanner.nextLine();
                input.add(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return input;
    }
}

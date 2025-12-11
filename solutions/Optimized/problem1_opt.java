import java.io.*;
import java.util.*;

public class problem1_opt {

    // Faster rotation using modular arithmetic instead of repeated operations.
    private static String rotate(String s, int steps) {
        int n = s.length();
        steps = ((steps % n) + n) % n; // normalize
        return s.substring(n - steps) + s.substring(0, n - steps);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader gridReader = new BufferedReader(new FileReader("../inputs/grid.txt"));
        BufferedReader dirReader = new BufferedReader(new FileReader("../inputs/directions.txt"));

        List<String> grid = new ArrayList<>();
        String line;

        while ((line = gridReader.readLine()) != null) {
            grid.add(line.trim());
        }

        // Directions: convert R/L into +1 / -1 and combine them
        String[] directions = dirReader.readLine().trim().split(" ");

        int netShift = 0;
        for (String d : directions) {
            if (d.equals("R")) netShift += 1;
            else if (d.equals("L")) netShift -= 1;
        }

        List<String> transformed = new ArrayList<>();

        for (String row : grid) {
            // Instead of rotating 5 times → rotate once using net shift
            transformed.add(rotate(row, netShift));
        }

        // Get middle row
        String middleRow = transformed.get(transformed.size() / 2);

        int sum = 0;
        for (char c : middleRow.toCharArray()) {
            sum += c; // no need for (int)c
        }

        System.out.println(sum);

        PrintWriter out = new PrintWriter("clue1.txt");
        out.println(sum);
        out.close();
    }
}


package task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try {
            String text = readInput(System.in);

            ConcordanceCalculator calculator = new ConcordanceCalculator(text);
            Concordance concordance = calculator.calculate();
            ConcordancePresenter presenter = new ConcordancePresenter(concordance);

            System.out.println(presenter);
        }
        catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private static String readInput(InputStream stream) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        StringBuilder result = new StringBuilder();
        String line;

        // Read until EOF
        while ((line = reader.readLine()) != null) {
            result.append(line);
            result.append("\n");
        }

        return result.toString();
    }
}

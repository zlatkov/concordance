package task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {

    public static List<TextMatch> findMatches(String text, Pattern pattern) {
        List<TextMatch> matches = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            TextMatch match = new TextMatch(matcher.start(), matcher.end());
            matches.add(match);
        }

        return matches;
    }

    public static <T> String join(List<T> values, String separator) {
        StringBuilder result = new StringBuilder();
        int valueIndex = 0;

        for (T value : values) {
            if (valueIndex > 0) {
                result.append(separator);
            }

            result.append(value);
            valueIndex++;
        }

        return result.toString();
    }
}

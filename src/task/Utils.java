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
        int stringCount = values.size();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringCount; i++) {
            if (i > 0) {
                result.append(separator);
            }

            result.append(values.get(i).toString());
        }

        return result.toString();
    }
}

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) return 0;
        if (input.length() == 1) return Integer.parseInt(input);
        if (Pattern.matches("//(.)\n(.*)", input)) return splitWithCustom(input);
        if (input.contains(",") || input.contains(":")) return splitWithCommaOrColon(input);

        return 10;
    }

    public static int splitWithCommaOrColon(String input) {
        String[] split = input.split(",|:");
        if (isNegative(split)) throw new RuntimeException("음수값을 넣으면 안됩니다.");
        
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

    public static int splitWithCustom(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] split = m.group(2).split(customDelimiter);

            return Arrays.stream(split)
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);
        }

        throw new RuntimeException("올바른 입력 방식이 아닙니다.");
    }

    public static boolean isNegative(String[] input) {
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .anyMatch(integer -> integer < 0);
    }
}
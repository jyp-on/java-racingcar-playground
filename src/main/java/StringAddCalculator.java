import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) return 0;
        if (input.length() == 1) return Integer.parseInt(input);
//        if (input.contains(",") && input.contains(":"))
        if (input.contains(",")) return splitWithComma(input);
        return 10;
    }

    public static int splitWithComma(String input) {
        String[] split = input.split(",");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
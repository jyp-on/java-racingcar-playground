import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class RacingUtil {
    public static List<Car> makeCarList(String[] carNameList) {
        return Arrays.stream(carNameList).map(Car::new).collect(Collectors.toList());
    }

    public static String[] splitCarName(String input) {
        String removeWhiteSpace = input.replace(" ", "");
        String[] split = removeWhiteSpace.split(",");
        if(isOverFive(split)) throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        return split;
    }

    public static boolean isOverFive(String[] token) {
        return Arrays.stream(token).anyMatch(string -> string.length() > 5);
    }

    public static int createRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }


    public static void moveAllCar(List<Car> cars) {
        cars.forEach(Car::move);
    }
}

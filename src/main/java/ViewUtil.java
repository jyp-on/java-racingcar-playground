import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ViewUtil {
    public static void playView(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            System.out.println(car.getName() + " : " + repeatString("-", car.getLocation()));
        }
    }

    public static void resultView(List<Car> carList) {
        int max = maxScore(carList);

        List<Car> winCarList = carList.stream()
                .filter(car -> car.getLocation() == max)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        winCarList.forEach(winCar -> sb.append(winCar.getName() + ", "));
        sb.delete(sb.length()-2, sb.length());
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }

    public static int maxScore(List<Car> carList) {
        return carList.stream()
                .map(Car::getLocation)
                .mapToInt(x -> x)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public static String repeatString(String target, int count) {
        String sum = target;
        for (int i = 0; i < count - 1; i++) {
            sum = sum.concat(target);
        }
        return sum;
    }
}

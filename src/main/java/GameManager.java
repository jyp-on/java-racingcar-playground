import java.util.List;
import java.util.Scanner;

public class GameManager {
    public static void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        Scanner sc = new Scanner(System.in);
        String[] carNameList = RacingUtil.splitCarName(sc.nextLine());
        List<Car> cars = RacingUtil.makeCarList(carNameList);

        System.out.println("시도할 회수는 몇회인가요?");
        int count = sc.nextInt();
        gamePlay(cars, count);
    }

    public static void gamePlay(List<Car> cars, int count) {
        System.out.println("\n실행 결과");
        ViewUtil.playView(cars);
        System.out.println();

        for (int i = 0; i < count; i++) {
            RacingUtil.moveAllCar(cars);
            ViewUtil.playView(cars);
            System.out.println();
        }

        ViewUtil.resultView(cars);
    }
}

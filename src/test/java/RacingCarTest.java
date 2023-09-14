import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    public void splitCarName() {
        String[] cars = RacingUtil.splitCarName("pobi, crong, honux");
        assertThat(cars.length).isEqualTo(3);

        assertThatThrownBy(() -> RacingUtil.splitCarName("pobissss, crong, honux"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void createCar() {
        String[] carNameList = RacingUtil.splitCarName("pobi, crong, honux");
        List<Car> cars = RacingUtil.makeCarList(carNameList);
    }

    @Test
    public void createRandomValue() {
        int randomValue = RacingUtil.createRandomValue();
        assertThat(randomValue).isBetween(0, 9);
    }

    @Test
    public void 화면표시() {
        String[] carNameList = RacingUtil.splitCarName("pobi, crong, honux");
        List<Car> cars = RacingUtil.makeCarList(carNameList);
        cars.get(0).move();
        cars.get(1).move();
        ViewUtil.playView(cars);
        ViewUtil.resultView(cars);
    }
}

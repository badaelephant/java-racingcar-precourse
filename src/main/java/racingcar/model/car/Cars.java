package racingcar.model.car;

import java.util.List;
import racingcar.model.strategy.MoveStrategy;

/**
 * 자동차 그룹 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Cars {

    private final List<Car> carList;

    public Cars(final List<Car> carList) {
        this.carList = carList;
    }

    public void moveAll(MoveStrategy moveStrategy) {
        for (Car car : carList) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

}

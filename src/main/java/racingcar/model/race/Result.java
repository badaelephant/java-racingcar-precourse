package racingcar.model.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.CarPosition;
import racingcar.model.car.Cars;
import racingcar.view.Output;


/**
 * 경기 결과 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Result {

    private final int round;
    private final Cars cars;

    private List<Car> winners = new ArrayList<>();

    public Result(int round, Cars cars) {
        this.round = round;
        this.cars = cars;

        checkWinner();
    }

    public List<Car> getWinners() {
        return winners;
    }

    private void checkWinner() {
        cars.orderCarsByPosition();
        winners = cars.getWinners();
    }

    public void printResult() {

        Output.printRoundResult(cars.getCarList());
    }
}

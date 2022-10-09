package racingcar.model.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.car.Car;
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

    private final List<String> winners = new ArrayList<>();

    public Result(int round, Cars cars) {
        this.round = round;
        this.cars = cars;

        checkWinner();
    }

    public List<String> getWinners() {
        return winners;
    }

    private void checkWinner() {
        List<Car> carList = cars.getCarList();
        Collections.sort(carList, Collections.reverseOrder());
        int winPosition = carList.get(0).getCarPosition();
        for (Car car : carList) {
            checkCoWinnerAndAddWinner(winPosition, car);
        }
    }

    private void checkCoWinnerAndAddWinner(int winPosition, Car car) {
        if (car.getCarPosition() == winPosition) {
            winners.add(car.getCarName());
        }
    }

    public void printResult() {

        Output.printRoundResult(cars.getCarList());
    }
}

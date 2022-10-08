package racingcar.model.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.view.Output;

public class Result {

    private final int round;
    private final Cars cars;

    private List<String> winners = new ArrayList<>();

    public Result(int round, Cars cars) {
        this.round = round;
        this.cars = cars;

        checkWinner();
    }
    public List<String> getWinners(){
        return winners;
    }

    private void checkWinner() {
        List<Car> carList = cars.getCarList();
        Collections.sort(carList, Collections.reverseOrder());
        int winPosition = carList.get(0).getPosition();
        for (Car car: carList){
            checkCoWinnerAndAddWinner(winPosition, car);
        }
    }

    private void checkCoWinnerAndAddWinner(int winPosition, Car car) {
        if(car.getPosition() == winPosition) {
            winners.add(car.getName());
        }
    }

    public void printResult(){

        Output.printRoundResult(cars.getCarList());
    }
}

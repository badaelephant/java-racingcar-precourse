package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.strategy.MoveStrategy;
import racingcar.model.value.ErrorMsg;

/**
 * 자동차 그룹 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public Cars(final String carNamesInput) {
        createCarList(carNamesInput);
    }

    private void createCarList(final String carNamesInput) {
        for (String carName : carNamesInput.split(",")) {
            carList.add(createCar(carName));
        }
        checkCarListSize();
    }

    private void checkCarListSize() {
        if(carList.size()<2){
            throw new IllegalArgumentException(ErrorMsg.ONE_CAR_NAME);
        }
    }

    private Car createCar(final String carName) {
        Car car = new Car(carName);
        validateDuplicatedCarName(car);
        return car;
    }

    private void validateDuplicatedCarName(final Car car) {
        if(carList.contains(car)){
            throw new IllegalArgumentException(ErrorMsg.DUPLICATE_NAME);
        }
    }

    public void moveAll(MoveStrategy moveStrategy) {
        for (Car car : carList) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getCarListSize(){ return carList.size();}

    public boolean isEmpty(){
        return this.carList.size() == 0;
    }

}

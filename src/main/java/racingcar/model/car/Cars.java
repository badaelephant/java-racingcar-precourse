package racingcar.model.car;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(final List<Car> carList) {
        this.carList = carList;
    }

    public void moveAll() {
        //TODO MoveStrategy 관련 코드 추가 필요
        for(Car car: carList){
            car.move();
        }
    }

    public List<Car> getCarList(){
        return carList;
    }

}

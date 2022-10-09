package racingcar.model.car;

import java.util.Objects;
import racingcar.model.strategy.MoveStrategy;

/**
 * 자동차 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Car implements Comparable<Car> {

    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition();
    }

    public String getCarName() {
        return name.getName();
    }

    public int getCarPosition() {
        return position.getPosition();
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position.moveOneStep();
        }
    }

    @Override
    public int compareTo(Car c) {
        return Integer.compare(this.getCarPosition(), c.getCarPosition());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getCarName(), car.getCarName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarName());
    }

}

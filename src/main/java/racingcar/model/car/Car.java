package racingcar.model.car;

import racingcar.model.strategy.MoveStrategy;

public class Car implements Comparable<Car> {
    private final CarName name;
    private final CarPosition position;
    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition();
    }

    public String getName() {
        return name.gatCarName();
    }

    public int getPosition() {
        return position.getCarPosition();
    }

    public void move(MoveStrategy moveStrategy){
        if(moveStrategy.isMovable()){
            position.moveOneStep();
        }
    }

    @Override
    public int compareTo(Car c){
        return Integer.compare(this.getPosition(), c.getPosition());
    }

}

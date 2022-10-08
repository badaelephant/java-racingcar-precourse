package racingcar.model.race;

import racingcar.model.car.Cars;
import racingcar.model.strategy.MoveStrategy;
import racingcar.model.value.Rule;

public class Round {
    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private int roundNumber;


    public Round(Cars cars, MoveStrategy moveStrategy){
        this.cars = cars;
        this.moveStrategy = moveStrategy;
        this.roundNumber = Rule.START_ROUND_NO;
    }

    public Result run(int round){
        cars.moveAll(moveStrategy);
        roundNumber = round;
        return new Result(roundNumber, cars);
    }

    public int getCurrentRound() {
        return roundNumber;
    }
}

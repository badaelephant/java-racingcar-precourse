package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.strategy.MoveStrategy;
import racingcar.model.strategy.RandomNumberMoveStrategy;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MoveStrategy moveStrategy = new RandomNumberMoveStrategy();
        RaceController raceController = new RaceController(moveStrategy);
        raceController.startRace();
        

    }
}

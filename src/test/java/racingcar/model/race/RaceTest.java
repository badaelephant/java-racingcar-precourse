package racingcar.model.race;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.strategy.RandomNumberMoveStrategy;

public class RaceTest {

    @Test
    void 공동_우승_테스트() {
        RandomNumberMoveStrategy strategy = new RandomNumberMoveStrategy();
        Car ferrari = new Car("페라리");
        Car tesla = new Car("테슬라");
        Cars cars = new Cars(Arrays.asList(ferrari, tesla));
        strategy.setMoveLimit(0);
        int round = 1;
        Race race = new Race(strategy, cars, round);
        race.start();
        List<String> winners = race.getRaceRecord().getFinalResult().getWinners();
        assertEquals(ferrari.getPosition(), 1);
        assertEquals(tesla.getPosition(), 1);
        assertEquals(winners.size(), 2);
    }

    @Test
    void 공동_패배_테스트() {
        RandomNumberMoveStrategy strategy = new RandomNumberMoveStrategy();
        Car ferrari = new Car("페라리");
        Car tesla = new Car("테슬라");
        Cars cars = new Cars(Arrays.asList(ferrari, tesla));
        strategy.setMoveLimit(10);
        int round = 1;
        Race race = new Race(strategy, cars, round);
        race.start();
        List<String> winners = race.getRaceRecord().getFinalResult().getWinners();
        assertEquals(ferrari.getPosition(), 0);
        assertEquals(tesla.getPosition(), 0);
        assertEquals(winners.size(), 2);
    }

}

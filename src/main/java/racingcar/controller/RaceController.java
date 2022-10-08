package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.race.Race;
import racingcar.model.race.RaceManager;
import racingcar.model.race.Record;
import racingcar.model.race.Result;
import racingcar.model.strategy.MoveStrategy;
import racingcar.view.Input;
import racingcar.view.Output;

/**
 * 레이스 컨트롤러
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class RaceController {

    private Race race;
    private final RaceManager raceManager;
    private final MoveStrategy moveStrategy;

    private List<Car> carList = new ArrayList<>();
    private int totalRound = 0;

    public RaceController(MoveStrategy moveStrategy) {
        this.raceManager = new RaceManager();
        this.moveStrategy = moveStrategy;
    }

    private void createRace() {
        if (carList.isEmpty()) {
            String carInput = Input.getCarListInput();
            carList = raceManager.addCars(carInput);
        }
        if (totalRound == 0) {
            String trialInput = Input.getRaceTrialInput();
            totalRound = raceManager.addTotalRound(trialInput);
        }
        Cars cars = new Cars(carList);
        race = new Race(moveStrategy, cars, totalRound);
    }

    public void startRace() {
        try {
            createRace();
        } catch (IllegalArgumentException e) {
            Output.printErrorMsg(e.getMessage());
            startRace();
            return;
        }
        race.start();
        if (race.isRaceOver()) {
            Record record = race.getRaceRecord();
            Result result = record.getFinalResult();
            List<String> winners = result.getWinners();
            race.announceFinalWinner(winners);
        }
    }
}

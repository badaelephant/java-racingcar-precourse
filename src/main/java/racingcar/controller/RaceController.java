package racingcar.controller;

import racingcar.model.car.Cars;
import racingcar.model.race.Race;
import racingcar.model.race.RaceManager;
import racingcar.model.race.Trial;
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

    private final Race race;
    private final RaceManager raceManager;


    public RaceController(MoveStrategy moveStrategy) {
        this.raceManager = new RaceManager();
        this.race = new Race(moveStrategy);
    }

    private void prepareRace() {
        prepareCars();
        prepareTrial();
    }

    private void prepareCars() {
        if (race.requireCarSetUp()) {
            String carInput = Input.getCarListInput().trim();
            Cars cars = raceManager.addCars(carInput);
            race.setupCars(cars);
        }
    }

    private void prepareTrial() {
        if (race.requireTrialSetup()) {
            String trialInput = Input.getRaceTrialInput().trim();
            Trial trial = raceManager.addTrial(trialInput);
            race.setupTrial(trial);
        }
    }

    public void startRace() {
        try {
            prepareRace();
        } catch (IllegalArgumentException e) {
            Output.printErrorMsg(e.getMessage());
            startRace();
        }
        try {
            race.start();
            race.announceFinalWinner();
        } catch (IllegalStateException e) {
            Output.printErrorMsg(e.getMessage());
        }
    }
}

package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.race.Race;
import racingcar.model.race.RaceManager;
import racingcar.model.race.Record;
import racingcar.model.race.Result;
import racingcar.model.race.Trial;
import racingcar.model.strategy.MoveStrategy;
import racingcar.model.value.Rule;
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

    private void createRace() {
        registerCars();
        registerTrial();
    }
    private void registerCars(){
        if(!race.isCarRegisterd()){
            String carInput = Input.getCarListInput().trim();
            Cars cars = raceManager.addCars(carInput);
            race.registerRaceCars(cars);
        }
    }
    private void registerTrial(){
        if(!race.isRaceReady()){
            String trialInput = Input.getRaceTrialInput().trim();
            Trial trial = raceManager.addTrial(trialInput);
            race.registerTrial(trial);
        }
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
        race.announceFinalWinner();
    }
}

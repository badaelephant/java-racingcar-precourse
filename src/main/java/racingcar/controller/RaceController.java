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
import racingcar.model.strategy.RandomNumberMoveStrategy;
import racingcar.view.Output;

public class RaceController {
    private Race race;
    private final RaceManager raceManager;
    private final MoveStrategy moveStrategy;

    private int createStep = 0;

    private List<Car> carList = new ArrayList<>();
    private int totalRound = 0;

    public RaceController(MoveStrategy moveStrategy){
        this.raceManager = new RaceManager();
        this.moveStrategy = moveStrategy;
    }
    private void createRace(){
        if(carList.isEmpty()){
            carList = raceManager.addCars();
        }
        if(totalRound==0){
            totalRound = raceManager.addTotalRound();
        }
        Cars cars = new Cars(carList);
        race = new Race(moveStrategy, cars, totalRound);
    }

    public void startRace() {
        try{
            createRace();
        }catch (IllegalArgumentException e){
            Output.printErrorMsg(e.getMessage());
            startRace();
        }
        race.start();
        if(race.isRaceOver()){
            Record record = race.getRaceRecord();
            Result result = record.getFinalResult();
            List<String> winners = result.getWinners();
            race.announceFinalWinner(winners);
        }
    }
}

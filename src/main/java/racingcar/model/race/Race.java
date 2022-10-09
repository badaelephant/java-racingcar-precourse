package racingcar.model.race;

import java.util.List;
import racingcar.model.car.Cars;
import racingcar.model.strategy.MoveStrategy;
import racingcar.view.Output;

/**
 * 경기 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Race implements RaceInterface {

    private final Record record;
    private final MoveStrategy moveStrategy;

    private RaceStatus raceStatus;
    private Cars cars;
    private Trial trial;

    public Race(MoveStrategy moveStrategy) {
        this.record = new Record();
        this.moveStrategy = moveStrategy;
        this.raceStatus = RaceStatus.PREPARING;
    }

    @Override
    public void start() {
        this.raceStatus = RaceStatus.DRIVING;
        Output.printRaceStart();
        for (int i = 1; i < trial.getTotalTrial() + 1; i++) {
            Result result = runNthRound(i);
            record.addRecord(result);
            result.printResult();
        }
        this.raceStatus = RaceStatus.RACE_OVER;
    }
    private Result runNthRound(int round) {
        cars.moveAll(moveStrategy);
        return new Result(round, cars);
    }

    @Override
    public void announceFinalWinner() {
        if (isRaceOver()) {
            Result result = record.getFinalResult();
            List<String> winners =  result.getWinners();
            Output.printRaceFinalWinner(winners);
        }
    }

    @Override
    public boolean isRaceOver() {
        return this.raceStatus == RaceStatus.RACE_OVER;
    }
    @Override
    public boolean isRaceReady() {
        return this.raceStatus == RaceStatus.READY;
    }

    public boolean isCarRegisterd(){
        return this.raceStatus == RaceStatus.CAR_REGISTERED;
    }

    @Override
    public boolean isRaceDriving() {
        return this.raceStatus == RaceStatus.DRIVING;
    }

    @Override
    public void registerRaceCars(Cars cars) {
        this.cars = cars;
        carRegisterd();
    }

    @Override
    public void registerTrial(Trial trial) {
        this.trial = trial;
        trialRegisterd();
    }


    private void carRegisterd() {
        this.raceStatus = RaceStatus.CAR_REGISTERED;
    }
    public void trialRegisterd() {
        this.raceStatus = RaceStatus.READY;
    }
}

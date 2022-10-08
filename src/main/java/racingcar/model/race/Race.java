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

    private final int totalRound;
    private final Record record;
    private final Round round;

    public Race(MoveStrategy moveStrategy, Cars cars, int totalRound) {
        this.totalRound = totalRound;
        this.record = new Record();
        this.round = new Round(cars, moveStrategy);
    }

    @Override
    public void start() {
        Output.printRaceStart();
        for (int i = 1; i < totalRound + 1; i++) {
            Result result = round.run(i);
            record.addRecord(result);
            result.printResult();
        }
    }

    @Override
    public void announceFinalWinner(List<String> winners) {
        Output.printRaceFinalWinner(winners);
    }

    @Override
    public boolean isRaceOver() {
        return totalRound == round.getCurrentRound();
    }

    @Override
    public Record getRaceRecord() {
        return record;
    }
}

package racingcar.model.race;


import java.util.List;
import racingcar.model.car.Cars;

public interface RaceInterface {

    public void start(int totalRound);

    public void announceFinalWinner(List<String> winners);

    public boolean isRaceOver();

    public Record getRaceRecord();

}

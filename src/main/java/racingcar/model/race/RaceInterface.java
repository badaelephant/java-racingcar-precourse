package racingcar.model.race;

import java.util.List;

/**
 * 경기 인터페이스
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public interface RaceInterface {

    void start();

    void announceFinalWinner(List<String> winners);

    boolean isRaceOver();

    Record getRaceRecord();

}

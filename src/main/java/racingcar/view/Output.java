package racingcar.view;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.CarPosition;
import racingcar.model.value.ErrorMsg;
import racingcar.model.value.RaceMsg;

/**
 * 출력 처리 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Output {

    public static void requestCarListInput() {
        System.out.println(RaceMsg.REQUEST_CAR_LIST_INPUT);
    }

    public static void requestRaceTrialInput() {
        System.out.println(RaceMsg.REQUEST_RACE_TRIAL_INPUT);
    }

    public static void printErrorMsg(String e) {
        System.out.println(ErrorMsg.BASE + e);
    }

    public static void printRoundResult(List<Car> cars) {
        System.out.println("\n");
        for (Car car : cars) {
            printRoundResultByCar(car);
        }
    }

    public static void printRaceStart() {
        System.out.println("\n");
        System.out.println(RaceMsg.RACE_RESULT_INTRODUCE);
    }

    public static void printRaceFinalWinner(List<Car> winners) {
        System.out.println("\n");
        StringBuilder builder = new StringBuilder();
        builder.append(RaceMsg.FINAL_WINNER);
        for (int i = 0; i < winners.size(); i++) {
            builder.append(returnWinnerText(i, winners.get(i)));
        }
        String winnerText = builder.toString();
        System.out.println(winnerText);
    }

    private static String returnWinnerText(int index, Car winner) {
        if (index == 0) {
            return winner.getCarName().toString();
        }
        return ", " + winner.getCarName().toString();
    }


    private static void printRoundResultByCar(Car car) {
        System.out.println(String.format("%s : %s", car.getCarName().toString(), printCarPosition(car.getCarPosition())));
    }

    private static String printCarPosition(CarPosition position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; position.biggerThan(new CarPosition(i)); i++) {
            builder.append(RaceMsg.PROGRESS_PARTICLE);
        }
        return builder.toString();
    }


}

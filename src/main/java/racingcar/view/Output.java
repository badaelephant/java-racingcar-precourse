package racingcar.view;

import java.util.List;
import racingcar.model.car.Car;
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

    public static void printRaceFinalWinner(List<String> winners) {
        System.out.println("\n");
        StringBuilder builder = new StringBuilder();
        builder.append(RaceMsg.FINAL_WINNER);
        for (int i = 0; i < winners.size(); i++) {
            builder.append(returnWinnerText(i, winners.get(i)));
        }
        String winnerText = builder.toString();
        System.out.println(winnerText);
    }

    private static String returnWinnerText(int index, String winner) {
        if (index == 0) {
            return winner;
        }
        return ", " + winner;
    }


    private static void printRoundResultByCar(Car car) {
        System.out.println(String.format("%s : %s", car.getName(), printCarPosition(car.getPosition())));
    }

    private static String printCarPosition(int position) {
        StringBuilder builder = new StringBuilder(position);
        for (int i = 0; i < position; i++) {
            builder.append(RaceMsg.PROGRESS_PARTICLE);
        }
        return builder.toString();
    }


}

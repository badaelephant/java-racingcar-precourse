package racingcar.view;

import racingcar.model.value.ErrorMsg;
import racingcar.model.value.RaceMsg;

public class Output {
    public static void requestCarListInput() {
        System.out.println(RaceMsg.REQUEST_CAR_LIST_INPUT);
    }
    public static void requestRaceTrialInput() {System.out.println(RaceMsg.REQUEST_RACE_TRIAL_INPUT);}
    public static void printErrorMsg(String e){System.out.println(ErrorMsg.BASE + e);}
}

package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getCarListInput() {
        Output.requestCarListInput();
        return Console.readLine();
    }

    public static String getRaceTrialInput() {
        Output.requestRaceTrialInput();
        return Console.readLine();
    }

}

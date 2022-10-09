package racingcar.model.race;

import racingcar.model.value.ErrorMsg;
import racingcar.model.value.Rule;

public class Trial {

    private static final String TRIAL_PATTERN = "^[1-9][0-9]*$";

    private int trial = Rule.DEFAULT_TRIAL;

    public Trial(final String trialInput) {
        validateTrialInput(trialInput);
        this.trial = Integer.parseInt(trialInput);
    }

    private void validateTrialInput(String trialInput) {
        if(!trialInput.matches(TRIAL_PATTERN)){
            throw new IllegalArgumentException(ErrorMsg.WRONG_TYPE);
        }
    }

    public int getTotalTrial(){
        return trial;
    }

    public boolean isNotSet(){
        return trial == Rule.DEFAULT_TRIAL;
    }
}

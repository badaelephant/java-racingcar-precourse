package racingcar.model.car;

import racingcar.model.value.Rule;

public class CarPosition {

    private int position;

    public CarPosition(){
        this.position = Rule.START_POSITION;
    }

    public void moveOneStep(){
        position += Rule.ONE_STEP;
    }


    public int getCarPosition() {
        return position;
    }
}

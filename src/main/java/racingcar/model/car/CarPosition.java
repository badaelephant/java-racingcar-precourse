package racingcar.model.car;

import java.util.Objects;
import racingcar.model.value.Rule;

/**
 * 자동차 위치 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class CarPosition {

    private int position;

    public CarPosition() {
        this.position = Rule.START_POSITION;
    }

    public void moveOneStep() {
        position += Rule.ONE_STEP;
    }

    public int getPosition() {
        return position;
    }

    public boolean biggerThan(final CarPosition carPosition) {
        return this.position > carPosition.position;
    }

    public boolean lesserThan(final CarPosition carPosition) {
        return this.position < carPosition.position;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition carPosition = (CarPosition) o;
        return position == carPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}

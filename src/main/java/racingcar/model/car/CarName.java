package racingcar.model.car;

import racingcar.model.value.ErrorMsg;
import racingcar.model.value.Rule;

public class CarName {
    private final String name;
    public CarName(String name) {
        this.name = name;
    }

    public String gatCarName() {
        return name;
    }
}

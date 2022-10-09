package racingcar.model.car;

import java.util.Objects;
import racingcar.model.value.ErrorMsg;
import racingcar.model.value.Rule;

/**
 * 자동차 이름객체(원시타입)
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class CarName {

    private final String WHITE_SPACE = " ";

    private final String name;


    public CarName(final String name) {
        validateWhiteSpace(name);
        validateCarNameLength(name);
        this.name = name;
    }

    private void validateCarNameLength(final String name) {
        if (name.length() < Rule.MIN_NAME_LENGTH || name.length() > Rule.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMsg.CAR_NAME_LENGTH_NO_MATCH);
        }
    }

    private void validateWhiteSpace(final String name) {
        if (name.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException(ErrorMsg.WHITE_SPACE);
        }
    }

    public String getName() {
        return name;
    }

}

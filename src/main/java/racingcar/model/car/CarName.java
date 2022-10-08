package racingcar.model.car;

/**
 * 자동차 이름객체(원시타입)
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class CarName {

    private final String name;

    public CarName(String name) {
        this.name = name;
    }

    public String gatCarName() {
        return name;
    }
}

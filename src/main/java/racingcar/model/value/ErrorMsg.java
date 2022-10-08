package racingcar.model.value;

/**
 * 에러 메시지 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class ErrorMsg {
    public static final String BASE = "[ERROR] ";
    public static final String EMPTY_INPUT = "입력이 비었습니다. 다시 입력해주세요";
    public static final String ONE_CAR_NAME = "경기를 위해선 차가 한대 이상 등록되어야합니다.";
    public static final String BLANK_NAME = "차 이름은 비어있을 수 없습니다. 1자 이상으로 넣어주세요.";
    public static final String DUPLICATE_NAME = "차 이름은 중복될 수 없습니다.";
    public static final String OVER_NAME_LENGTH = "차 이름은 5글자를 초과할 수 없습니다. 5글자 이하로 입력해주세요.";
    public static final String WRONG_TYPE = "시도횟수는 1이상 숫자여야합니다.";
    public static final String INPUT_ZERO = "시도횟수는 1회이상이어야 합니다.";
}

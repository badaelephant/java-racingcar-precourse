package racingcar.model.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.value.Rule;

public class RandomNumberMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMovable() {
        return actByStrategy() >= Rule.MOVE_LIMIT;
    }

    @Override
    public int actByStrategy() {
        return Randoms.pickNumberInRange(Rule.MIN_RANDOM, Rule.MAX_RANDOM);
    }


}

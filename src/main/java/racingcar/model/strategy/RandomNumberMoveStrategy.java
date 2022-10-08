package racingcar.model.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.value.Rule;

public class RandomNumberMoveStrategy implements MoveStrategy {
    private int moveLimit = Rule.MOVE_LIMIT;
    @Override
    public boolean isMovable() {
        return actByStrategy() >= moveLimit;
    }

    @Override
    public int actByStrategy() {
        return Randoms.pickNumberInRange(Rule.MIN_RANDOM, Rule.MAX_RANDOM);
    }

    public void setMoveLimit(int moveLimit){
        this.moveLimit = moveLimit;
    }
}

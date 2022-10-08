package racingcar.model.race;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private List<Result> record = new ArrayList<>();

    public List<Result> getAllRecord(){
        return record;
    }

    public Result getFinalResult(){
        return record.get(record.size() -1);
    }

    public void addRecord(Result result) {
        record.add(result);
    }
}

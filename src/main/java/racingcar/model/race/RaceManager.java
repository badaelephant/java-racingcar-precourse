package racingcar.model.race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.value.ErrorMsg;
import racingcar.model.value.Rule;
import racingcar.view.Input;
import racingcar.view.Output;

public class RaceManager {


    public List<Car> addCars() {
        String carInput = Input.getCarListInput();
        validateCarListInput(carInput);
        return generateCarList(carInput);
    }

    public int addTotalRound() {
        String trialInput = Input.getRaceTrialInput();
        validateTrialInput(trialInput);
        return Integer.parseInt(trialInput);
    }

    private List<Car> generateCarList(String carInput) {
        String[] carNameArray = carInput.split(Rule.SEPARATOR);
        checkDuplicatedName(carNameArray);
        List<Car> carList = new ArrayList<>();
        for(String carName: carNameArray){
            validateCarNameLength(carName);
            carList.add(new Car(carName));
        }
        return carList;
    }

    private void checkDuplicatedName(String[] carNameArray) {
        List<String> carNameList = Arrays.asList(carNameArray);
        Set<String> carNames = new HashSet<>(carNameList);
        if (carNameList.size() != carNames.size()) {
            throw new IllegalArgumentException(ErrorMsg.DUPLICATE_NAME);
        }
    }

    private void validateCarNameLength(String carName) {
        if(carName.length()>5){
            throw new IllegalArgumentException(ErrorMsg.OVER_NAME_LENGTH);
        }
    }
    private void validateCarListInput(String carInput) {
        System.out.println(carInput);
        if(carInput == null || carInput.isEmpty()){
            throw new IllegalArgumentException(ErrorMsg.EMPTY_INPUT);
        }
        if(carInput.indexOf(",")<0){
            throw new IllegalArgumentException(ErrorMsg.ONE_CAR_NAME);
        }
    }



    private void validateTrialInput(String trialInput) {
        if(trialInput == null || trialInput.isEmpty()){
            throw new IllegalArgumentException(ErrorMsg.EMPTY_INPUT);
        }
        if(!trialInput.matches("[0-9]+")){
            throw new IllegalArgumentException(ErrorMsg.WRONG_TYPE);
        }
        if(Integer.parseInt(trialInput) == 0){
            throw new IllegalArgumentException(ErrorMsg.INPUT_ZERO);
        }
    }

}

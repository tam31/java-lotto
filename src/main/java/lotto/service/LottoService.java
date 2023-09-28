package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.validation.DataValidation;

import java.util.HashMap;
import java.util.List;

public class LottoService {

    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;
    private static final int DIVIDE = 1000;
    private static HashMap<List<Integer>,Integer> lottoList = new HashMap<>();
    DataValidation dataValidation = new DataValidation();
    public int checkMoney(String money){
        return dataValidation.isCheckNumber(money);
    }
    public HashMap<List<Integer>,Integer> pullLottoNumber(int money){
        for(int i=0; i<money/DIVIDE; i++){
            List<Integer> numbers = getNumbers();
            Lotto lotto = new Lotto(numbers);
            lottoList.put(lotto.getNumbers(),i);
        }
        return lottoList;
    }

    private List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(START, END, COUNT);
    }

    public List<Integer> inputLottoNumber(String numbers){
        List<Integer> number = dataValidation.isCheckNumbers(numbers);
        Lotto lotto = new Lotto(number);
        return lotto.getNumbers();
    }

    public int inputBonuse(String bonusNumber, List<Integer> lottoNumbers) {
        int bonus = dataValidation.changeNumber(bonusNumber);
        dataValidation.isNotDuplicationNumber(bonus, lottoNumbers);
        return bonus;
    }
}

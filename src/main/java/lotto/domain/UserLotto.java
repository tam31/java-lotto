package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.HashMap;
import java.util.List;

public class UserLotto {
    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;
    private static HashMap<List<Integer>,Integer> lottoList = new HashMap<>();

    public HashMap<List<Integer>,Integer> getLottoNumber(int money){
        for(int i=0; i<money/1000; i++){
            List<Integer> numbers = getNumbers();
            Lotto lotto = new Lotto(numbers);
            lottoList.put(lotto.getNumbers(),i);
        }
        return lottoList;
    }

    private List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(START, END, COUNT);
    }

}

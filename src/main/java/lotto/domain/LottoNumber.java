package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private List<Integer> lottoNumber;
    private Integer bonus;

    public LottoNumber(String lottoNumber) {
        this.lottoNumber = splitNumber(lottoNumber);
    }

    public List<Integer> splitNumber(String lottoNumber){
        String[] numbers = lottoNumber.split(",");
        List<Integer> lottoNumberList = addLottoNumber(numbers);
        Lotto lotto = new Lotto(lottoNumberList);
        return lotto.getNumbers();
    }

    private List<Integer> addLottoNumber(String[] numbers) {
        List<Integer> lottoNumberList = new ArrayList<>();
        for(String number: numbers){
            lottoNumberList.add(changeNumber(number));
        }
        return lottoNumberList;
    }

    private int changeNumber(String number) {
        return Integer.parseInt(number);
    }
}

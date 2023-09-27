package lotto.domain;

import java.util.List;

public class LottoNumber {
    private List<Integer> lottoNumber;
    private Integer bonus;

    public LottoNumber(String lottoNumber) {
        this.lottoNumber = splitNumber(lottoNumber);
    }

    public List<Integer> splitNumber(String lottoNumber){
        String[] numbers = lottoNumber.split(",");
    }
}

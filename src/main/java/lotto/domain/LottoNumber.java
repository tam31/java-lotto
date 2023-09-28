package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private List<Integer> lottoNumber;
    private Integer bonus;

    public LottoNumber(List<Integer> lottoNumber, Integer bonus) {
        this.lottoNumber = lottoNumber;
        this.bonus = bonus;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public Integer getBonus() {
        return bonus;
    }


}

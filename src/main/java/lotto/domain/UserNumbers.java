package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class UserNumbers {
    private int money;
    private HashMap<List<Integer>,Integer> pullLottoNumbers;
    private HashMap<Rank, Integer> lottoCount = new HashMap<>();
    private Long benefitMoney;

    public UserNumbers() {
        basicResultFrame();
    }

    private void basicResultFrame() {
        for(Rank rank:Rank.values()){
            lottoCount.put(rank,0);
        }
    }

    public int getMoney() {
        return money;
    }

    public void inputMoney(int money){
        this.money = money;
    }
    public HashMap<List<Integer>, Integer> getPullLottoNumbers() {
        return pullLottoNumbers;
    }

    public void pullLottoNumbers(HashMap<List<Integer>, Integer> lottoNumber){
        pullLottoNumbers = lottoNumber;
    }

    public HashMap<Rank, Integer> getLottoCount() {
        return lottoCount;
    }

    public void addLottoCount(Rank rank){
        lottoCount.put(rank, lottoCount.get(rank)+1);
    }

    public Long getBenefitMoney() {
        return benefitMoney;
    }

    public void addBenefitMoney(Long benefitMoney) {
        this.benefitMoney = benefitMoney;
    }

}

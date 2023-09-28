package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class UserNumbers {
    private int money;
    private HashMap<List<Integer>,Integer> userLottoMap;
    private HashMap<Integer, Integer> lottoCount = new HashMap<>();
    private Long benefitMoney;

    public Long getBenefitMoney() {
        return benefitMoney;
    }

    public void addBenefitMoney(Long benefitMoney) {
        this.benefitMoney = benefitMoney;
    }

    public UserNumbers(String money) {
        this.money = changeMoney(money);
        this.userLottoMap = inputLotto();
        basicResultFrame();
    }

    private void basicResultFrame() {
        for(Rank rank:Rank.values()){
            lottoCount.put(rank.getCount(),0);
        }
    }

    public int getMoney() {
        return money;
    }

    public int changeMoney(String money){
        int cash = getChageMoney(money);
        isCheckMoney(cash);
        return cash;
    }

    public HashMap<Integer, Integer> getLottoCount() {
        return lottoCount;
    }

    public void addLottoCount(int number){
        lottoCount.put(number, lottoCount.get(number)+1);
    }

    private void isCheckMoney(int cash) {
        if(cash %1000 !=0){
            throw new IllegalArgumentException();
        }
    }

    private int getChageMoney(String money) {
        return Integer.parseInt(money);
    }


    public HashMap<List<Integer>, Integer> getUserLottoMap() {
        return userLottoMap;
    }

    public HashMap<List<Integer>,Integer> inputLotto(){
        UserLotto userLotto = new UserLotto();
        return userLotto.getLottoNumber(money);
    }
}

package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class UserNumbers {
    private int money;
    private HashMap<List<Integer>,Integer> userLottoMap;

    public UserNumbers(String money) {
        this.money = changeMoney(money);
        this.userLottoMap = inputLotto();
    }

    public int getMoney() {
        return money;
    }

    public int changeMoney(String money){
        int cash = getChageMoney(money);
        isCheckMoney(cash);
        return cash;
    }

    private static void isCheckMoney(int cash) {
        if(cash %1000 !=0){
            throw new IllegalArgumentException();
        }
    }

    private static int getChageMoney(String money) {
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

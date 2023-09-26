package lotto.domain;

import java.util.List;

public class UserNumbers {
    private int money;

    public int getMoney() {
        return money;
    }

    public void inputMoney(String money) {
        this.money = Integer.parseInt(money);
    }
}

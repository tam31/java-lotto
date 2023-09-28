package lotto.domain;

public enum Rank {
    Three(3,5000l,"5,000"),
    Four(4,50000l,"50,000"),
    Five(5, 1500000l,"1,500,000"),
    Six(6, 30000000l,"30,000,000"),
    Seven(7, 2000000000l,"2,000,000,000");

    final private int count;
    final private Long money;
    final private String viewMoney;

    Rank(int count, Long money,String viewMoney) {
        this.count = count;
        this.money = money;
        this.viewMoney = viewMoney;
    }

    public int getCount() {
        return count;
    }

    public Long getMoney() {
        return money;
    }

    public String getViewMoney() {
        return viewMoney;
    }
}

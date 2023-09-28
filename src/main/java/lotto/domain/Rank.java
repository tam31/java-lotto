package lotto.domain;

public enum Rank {
    Three(3,5000l),
    Four(4,50000l),
    Five(5, 1500000l),
    Six(6, 30000000l),
    Seven(7, 2000000000l);

    final private int count;
    final private Long money;

    Rank(int count, Long money) {
        this.count = count;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public Long getMoney() {
        return money;
    }

}

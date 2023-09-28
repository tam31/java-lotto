package lotto.validation;

public class DataValidation {
    private static int unitMoney = 1000;

    public int isCheckMoney(String money){
        try{
            int result = changeMoney(money);
            return result;
        }catch (NumberFormatException n){
            throw new IllegalArgumentException("[ERROR] 금액을 입력하세요");
        }
    }

    public int changeMoney(String money){
        return Integer.parseInt(money);
    }
    public void checkMoney(int money){
        if(money%unitMoney!=0){
            throw new IllegalArgumentException(String.format("[ERROR]%d원 단위로 나눌수 없습니다.",unitMoney));
        }
    }
}

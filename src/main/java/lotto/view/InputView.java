package lotto.view;

public class InputView {
    private static final String ENTER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String Lotto_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONES_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void inputMoney(){
        System.out.println(ENTER_MONEY_MESSAGE);
    }
    public static void lottoNumber(){
        System.out.println(Lotto_NUMBER_MESSAGE);
    }

}

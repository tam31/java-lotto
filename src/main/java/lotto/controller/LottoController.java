package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.UserNumbers;
import lotto.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutputView;

public class LottoController {

    private static UserNumbers user;
    private static LottoNumber lotto;
    public void startGame(){
        InputView.inputMoney();
        user = new UserNumbers(Console.readLine());
        OutputView.lottoCount(user.getMoney(), user.getUserLottoMap());
        InputView.lottoNumber();
        lotto = new LottoNumber(Console.readLine());
        System.out.println(user.getUserLottoMap());
    }
}

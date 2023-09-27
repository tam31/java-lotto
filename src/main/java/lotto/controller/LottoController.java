package lotto.controller;

import lotto.domain.UserNumbers;
import lotto.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutputView;

public class LottoController {

    private static UserNumbers user;
    public void startGame(){
        InputView.inputMoney();
        user = new UserNumbers(Console.readLine());
        OutputView.lottoCount(user.getMoney(), user.getUserLottoMap());
        System.out.println(user.getUserLottoMap());
    }
}

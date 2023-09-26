package lotto.controller;

import lotto.domain.UserNumbers;
import lotto.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class LottoController {

    private static UserNumbers user;
    public void startGame(){
        InputView.inputMoney();
        user = new UserNumbers();
        user.inputMoney(Console.readLine());
    }
}

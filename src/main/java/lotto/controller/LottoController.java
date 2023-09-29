package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.UserNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class LottoController {

    private static UserNumbers user;
    private static LottoNumber lotto;
    private static LottoService service = new LottoService();
    public void startGame(){
        try {
            user = new UserNumbers();
            buyLottoAndNumber();

            getLottoNumber();

            getLottoCount();
            getBenefitPercent();
        }catch (IllegalArgumentException e){

        }
    }

    private void buyLottoAndNumber() {
        InputView.inputMoney();
        user.inputMoney(service.checkMoney(Console.readLine()));
        user.pullLottoNumbers(service.pullLottoNumber(user.getMoney()));
        OutputView.lottoCount(user.getMoney(), user.getPullLottoNumbers());
    }

    private void getLottoNumber() {
        InputView.lottoNumber();
        List<Integer> isLottoNumbers = service.inputLottoNumber(Console.readLine());
        InputView.bonesNumber();
        int bonusNumber = service.inputBonuse(Console.readLine(), isLottoNumbers);
        lotto = new LottoNumber(isLottoNumbers, bonusNumber);
    }

    private void getLottoCount(){
        HashMap<Rank, Integer> rankLottoCount = service.resultLottoCount(user.getPullLottoNumbers(), lotto.getLottoNumber(), lotto.getBonus(), user.getLottoCount());
        user.isLottoCount(rankLottoCount);
        OutputView.summaryLotto(user.getLottoCount());
    }
    private void getBenefitPercent() {
        user.addBenefitMoney(service.sumLottoBenefit(user.getLottoCount(), user.getMoney()));
        OutputView.allBenefit(user.getBenefitMoney());
    }
}

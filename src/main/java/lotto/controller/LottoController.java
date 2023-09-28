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
        InputView.inputMoney();
        user = new UserNumbers();
        user.inputMoney(service.checkMoney(Console.readLine()));
        user.pullLottoNumbers(service.pullLottoNumber(user.getMoney()));
        OutputView.lottoCount(user.getMoney(), user.getPullLottoNumbers());

        InputView.lottoNumber();
        List<Integer> isLottoNumbers = service.inputLottoNumber(Console.readLine());
        InputView.bonesNumber();
        int bonusNumber = service.inputBonuse(Console.readLine(), isLottoNumbers);
        lotto = new LottoNumber(isLottoNumbers, bonusNumber);

        HashMap<Rank, Integer> rankLottoCount = service.resultLottoCount(user.getPullLottoNumbers(), lotto.getLottoNumber(), lotto.getBonus(), user.getLottoCount());
        user.isLottoCount(rankLottoCount);
        OutputView.winLottoCount(user.getLottoCount());
//        resultLottoCount();
//        OutputView.winLottoCount(user.getLottoCount());
//        double benefitNumber=benefitMoney(user.getBenefitMoney(), user.getMoney());
//        OutputView.allBenefit(benefitNumber);
    }

    public double benefitMoney(long sumMoney, int buyMoney){
        double result = ((double) sumMoney / buyMoney)*100;
        return result;
    }
}

package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.UserNumbers;
import lotto.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private static UserNumbers user;
    private static LottoNumber lotto;
    public void startGame(){
        InputView.inputMoney();
        user = new UserNumbers(Console.readLine());
        OutputView.lottoCount(user.getMoney(), user.getUserLottoMap());
        InputView.lottoNumber();
        lotto = new LottoNumber(Console.readLine());
        InputView.bonesNumber();
        lotto.putBonus(Console.readLine());
        System.out.println(user.getUserLottoMap());
        resultLottoCount();
        OutputView.winLottoCount(user.getLottoCount());
        double benefitNumber=benefitMoney(user.getBenefitMoney(), user.getMoney());
        OutputView.allBenefit(benefitNumber);
    }

    private static void resultLottoCount() {
        long sum = 0;
        for(List<Integer> userLotto: user.getUserLottoMap().keySet()){
            int cnt = 0;
            for(int number: lotto.getLottoNumber()){
                if(userLotto.contains(number)){
                    cnt +=1;
                }
            }
            for(Rank rank: Rank.values()){
                if(rank.getCount()==cnt){
                    user.addLottoCount(cnt);
                    sum+= rank.getMoney();
                }
            }

        }
        System.out.println(user.getLottoCount());
        user.addBenefitMoney(sum);
    }

    public double benefitMoney(long sumMoney, int buyMoney){
        double result = ((double) sumMoney / buyMoney)*100;
        return result;
    }
}

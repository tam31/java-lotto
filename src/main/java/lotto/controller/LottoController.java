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
            boolean isBonuse = false;
            if(userLotto.contains(lotto.getBonus())){
                isBonuse = true;
            }

            for(int number: lotto.getLottoNumber()){
                if(userLotto.contains(number)){
                    cnt +=1;
                }
            }
            for(Rank rank: Rank.values()){
                if(cnt ==4 && isBonuse){
                    user.addLottoCount(Rank.SECOND_FIVE);
                    sum+= Rank.SECOND_FIVE.getMoney();
                    break;
                }
                else if(rank.getCount()==cnt){
                    user.addLottoCount(rank);
                    sum+= rank.getMoney();
                    break;
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

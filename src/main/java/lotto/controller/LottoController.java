package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.UserNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private static UserNumbers user;
    private static LottoNumber lotto;
    private static LottoService service;
    public void startGame(){
        InputView.inputMoney();
        service = new LottoService();
        user = new UserNumbers();
        user.inputMoney(service.checkMoney(Console.readLine()));
        user.pullLottoNumbers(service.pullLottoNumber(user.getMoney()));
        OutputView.lottoCount(user.getMoney(), user.getPullLottoNumbers());

        InputView.lottoNumber();
        List<Integer> isLottoNumbers = service.inputLottoNumber(Console.readLine());
        InputView.bonesNumber();
        int bonusNumber = service.inputBonuse(Console.readLine(), isLottoNumbers);


        System.out.println(user.getPullLottoNumbers());
        resultLottoCount();
        OutputView.winLottoCount(user.getLottoCount());
        double benefitNumber=benefitMoney(user.getBenefitMoney(), user.getMoney());
        OutputView.allBenefit(benefitNumber);
    }

    private static void resultLottoCount() {
        long sum = 0;
        for(List<Integer> userLotto: user.getPullLottoNumbers().keySet()){
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

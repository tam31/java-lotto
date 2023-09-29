package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.Lotto;
import lotto.domain.Rank;
import lotto.validation.DataValidation;

import java.util.HashMap;
import java.util.List;

public class LottoService {

    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;
    private static final int DIVIDE = 1000;
    private static HashMap<List<Integer>,Integer> lottoList = new HashMap<>();
    DataValidation dataValidation = new DataValidation();
    public int checkMoney(String money){
        dataValidation.isCheckNumber(money);
        int changeMoney = dataValidation.changeNumber(money);
        dataValidation.checkMoney(changeMoney);
        return changeMoney;
    }
    public HashMap<List<Integer>,Integer> pullLottoNumber(int money){
        for(int i=0; i<money/DIVIDE; i++){
            List<Integer> numbers = getNumbers();
            Lotto lotto = new Lotto(numbers);
            lottoList.put(lotto.getNumbers(),i);
        }
        return lottoList;
    }

    private List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(START, END, COUNT);
    }

    public List<Integer> inputLottoNumber(String numbers){
        List<Integer> number = dataValidation.isCheckNumbers(numbers);
        Lotto lotto = new Lotto(number);
        return lotto.getNumbers();
    }

    public int inputBonuse(String bonusNumber, List<Integer> lottoNumbers) {
        int bonus = dataValidation.changeNumber(bonusNumber);
        dataValidation.isNotDuplicationNumber(bonus, lottoNumbers);
        return bonus;
    }


    public HashMap<Rank, Integer> resultLottoCount(HashMap<List<Integer>, Integer> pullLottoNumbers,
                                 List<Integer> lotto, int bonus,
                                 HashMap<Rank, Integer> lottoCount) {

        for(List<Integer> userLotto: pullLottoNumbers.keySet()){
            boolean isBonuse = false;
            isBonuse = isContainBonus(bonus, userLotto);
            int count = checkContainCount(userLotto, lotto);

            if(count ==4 && isBonuse){
                lottoCount.put(Rank.SECOND_FIVE, lottoCount.get(Rank.SECOND_FIVE)+1);
                continue;
            }
            if(isCompareRankToCount(count)){
                Rank rank = compareRankToCount(count);
                lottoCount.put(rank, lottoCount.get(rank)+1);
            }
        }
        return lottoCount;
    }

    private boolean isContainBonus(int bonus, List<Integer> userLotto) {
        if(userLotto.contains(bonus)){
            return true;
        }
        return false;
    }

    private int checkContainCount(List<Integer> userLotto, List<Integer> lotto) {
        int count = 0;
        for(int number: lotto){
            if(userLotto.contains(number)){
                count +=1;
            }
        }
        return count;
    }

    private boolean isCompareRankToCount(int lottoCount) {
        for(Rank rank: Rank.values()){
            if(rank.getCount()==lottoCount){
                return true;
            }
        }
        return false;
    }

    private Rank compareRankToCount(int count) {
        Rank answer = Rank.Three;
        for(Rank rank: Rank.values()){
            if(rank.getCount()==count){
                return rank;
            }
        }
        return answer;
    }

    public double sumLottoBenefit(HashMap<Rank, Integer> rankLottoCount, int buyMoney) {
        double sumMoney = 0;
        for(Rank rank: Rank.values()){
            sumMoney+= (rankLottoCount.get(rank)*rank.getMoney());
        }
        sumMoney = getBenefit(sumMoney,buyMoney);
        return sumMoney;
    }

    private double getBenefit(double sumMoney,int buyMoney) {
        return (sumMoney/buyMoney)*100;
    }
}

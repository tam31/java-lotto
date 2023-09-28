package lotto.view;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private final static int DIVID = 1000;
    private final static String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private final static String SUMMARY_MESSAGE = "당첨통계.";
    private final static String LOTTO_RESULT_COUNT_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private final static String LOTTO_RESULT_SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private final static String LOTTO_RESULT_BENEFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void lottoCount(int money,HashMap<List<Integer>, Integer> lottoNumbers){
        System.out.println(money/DIVID+LOTTO_COUNT_MESSAGE);
        lottoNumber(lottoNumbers);
    }

    public static void lottoNumber(HashMap<List<Integer>, Integer> lottoNumbers){
        for (List<Integer> lotto: lottoNumbers.keySet()) {
            System.out.println(lotto);
        }
    }

    public static void summaryLotto(HashMap<Rank, Integer> lottoCount){
        System.out.println(SUMMARY_MESSAGE);
        System.out.println("---");
        winLottoCount(lottoCount);
    }

    public static void winLottoCount(HashMap<Rank, Integer> lottoCount) {
        for(Rank rank:Rank.values()){
            if(rank==Rank.SECOND_FIVE){
                System.out.printf(LOTTO_RESULT_SECOND_MESSAGE,rank.getCount(),rank.getViewMoney(),lottoCount.get(rank));
            }
            System.out.printf(LOTTO_RESULT_COUNT_MESSAGE,rank.getCount(),rank.getViewMoney(),lottoCount.get(rank));
        }

    }

    public static void allBenefit(double number){
        System.out.printf(LOTTO_RESULT_BENEFIT_MESSAGE,number);
    }
}

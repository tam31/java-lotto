package lotto.view;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private final static int DIVID = 1000;
    private final static String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private final static String SUMMARY_MESSAGE = "당첨통계.";
    private final static String LOTTO_RESULT_COUNT_MESSAGE = "%d개 일치 (%s원) - %d개\n";

    public static void lottoCount(int money,HashMap<List<Integer>, Integer> lottoNumbers){
        System.out.println(money/DIVID+LOTTO_COUNT_MESSAGE);
        lottoNumber(lottoNumbers);
    }

    public static void lottoNumber(HashMap<List<Integer>, Integer> lottoNumbers){
        for (List<Integer> lotto: lottoNumbers.keySet()) {
            System.out.println(lotto);
        }
    }

    public static void summaryLotto(HashMap<Integer, Integer> lottoCount){
        System.out.println(SUMMARY_MESSAGE);
        System.out.println("---");
        winLottoCount(lottoCount);
    }

    public static void winLottoCount(HashMap<Integer, Integer> lottoCount) {
        for(Rank rank:Rank.values()){
            System.out.printf(LOTTO_RESULT_COUNT_MESSAGE,rank.getCount(),rank.getViewMoney(),lottoCount.get(rank.getCount()));
        }

    }

}

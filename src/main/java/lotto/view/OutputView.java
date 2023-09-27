package lotto.view;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private final static int DIVID = 1000;
    private final static String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private final static String SUMMARY_MESSAGE = "당첨통계.";

    public static void lottoCount(int money,HashMap<List<Integer>, Integer> lottoNumbers){
        System.out.println(money/DIVID+LOTTO_COUNT_MESSAGE);
        lottoNumber(lottoNumbers);
    }

    public static void lottoNumber(HashMap<List<Integer>, Integer> lottoNumbers){
        for (List<Integer> lotto: lottoNumbers.keySet()) {
            System.out.println(lotto);
        }
    }

    public static void summaryLotto(){
        System.out.println(SUMMARY_MESSAGE);
        System.out.println("---");
    }

}
